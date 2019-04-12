package com.jomilanez.contentapi

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.SecurityConfiguration
import springfox.documentation.swagger.web.SecurityConfigurationBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2

const val API_KEY_HEADER = "api-key"

@EnableSwagger2
@Configuration
@EnableConfigurationProperties(SwaggerProperties::class)
class SwaggerConfiguration(private val swaggerProperties: SwaggerProperties) {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .host(swaggerProperties.host)
            .protocols(setOf(swaggerProperties.protocol))
            .apiInfo(apiInfo())
            .securitySchemes(listOf(apiKeyWithName(API_KEY_HEADER)))
            .securityContexts(listOf(SecurityContext.builder().securityReferences(globalAuth()).build()))
            .useDefaultResponseMessages(false)
            .produces(setOf("application/json"))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.jomilanez.contentapi"))
            .paths(PathSelectors.any())
            .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("Content API")
            .description("Retrieves Content based on user information if provided")
            .termsOfServiceUrl("")
            .contact(Contact("wd", "", ""))
            .version("1.0")
            .build()

    }

    private fun globalAuth(): List<SecurityReference> = listOf(
        SecurityReference(
            API_KEY_HEADER, listOf(
                AuthorizationScope("*", "all access to resources")
            ).toTypedArray()
        )
    )

    private fun apiKeyWithName(name: String): ApiKey = ApiKey(name, name, "header")
}
