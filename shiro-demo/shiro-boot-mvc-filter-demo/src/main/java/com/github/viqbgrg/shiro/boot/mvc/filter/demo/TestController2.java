package com.github.viqbgrg.shiro.boot.mvc.filter.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhj
 */
@RestController
@RequestMapping("test")
public class TestController2 {
    @GetMapping
    public String firstTest() {
        return "Hello World";
    }
}
