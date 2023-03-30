package com.kevin.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin lau (双鹰)
 */
@RestController
@RequestMapping()
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }
}
