package com.jomilanez.contentapi

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("swagger")
class SwaggerProperties(var host: String = "", var protocol: String = "")
