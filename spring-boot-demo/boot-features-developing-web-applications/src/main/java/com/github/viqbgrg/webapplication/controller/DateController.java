package com.github.viqbgrg.webapplication.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("date")
public class DateController {

    @GetMapping("")
    public Result date() {
        Result result = new Result();
        result.setTime(LocalDateTime.now());
        return result;
    }

    @Data
    public static class Result {
        private LocalDateTime time;
    }
}
