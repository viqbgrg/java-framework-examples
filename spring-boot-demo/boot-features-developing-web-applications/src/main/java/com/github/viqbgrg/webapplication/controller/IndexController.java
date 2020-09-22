package com.github.viqbgrg.webapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/dex")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "11111";
    }
}
