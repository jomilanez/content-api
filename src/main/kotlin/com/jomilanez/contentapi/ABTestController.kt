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
    tags = ["Default content"]
)
class ABTestController {
    @GetMapping("/abtest")
    @ResponseStatus(OK)
    @ApiOperation("Delivers different results")
    fun getDefaultContent(
    ) = "Response from group A"
}

