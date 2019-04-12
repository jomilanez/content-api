package com.jomilanez.contentapi

import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ABTestController {
    @GetMapping("/abtest")
    @ResponseStatus(OK)
    fun getAbTestGroup(
    ) = "Response from group A"
}

