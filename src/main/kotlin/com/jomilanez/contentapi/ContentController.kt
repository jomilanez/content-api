package com.jomilanez.contentapi

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
@Api(
    description = "Delivers content.",
    tags = ["Content"]
)
class DefaultContentController {
    @GetMapping("/content")
    @ResponseStatus(OK)
    @ApiOperation("Delivers content")
    fun getDefaultContent(
    ): List<News> = listOf(News(id = "id", title = "sample title", category = "sports"))
}

data class News(
    val id: String,
    val title: String,
    val category: String
)
