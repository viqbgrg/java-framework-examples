package com.github.viqbgrg.springboottesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nnj
 */
@RestController
@RequestMapping("")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
