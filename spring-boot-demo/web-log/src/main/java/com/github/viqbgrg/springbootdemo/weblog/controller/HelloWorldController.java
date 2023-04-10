package com.github.viqbgrg.springbootdemo.weblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("test")
    public String getTest() throws InterruptedException {
        Thread.sleep(5000);
        return "success";
    }
}
