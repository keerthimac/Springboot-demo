package com.company.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/test ")
public class HttpRequestHandleEx {
    @GetMapping(value = "/hello")
    public String getStudent() {
        return "Hello";
    }
}
