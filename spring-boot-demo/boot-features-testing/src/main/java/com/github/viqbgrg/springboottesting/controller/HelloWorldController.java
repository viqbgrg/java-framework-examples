package com.github.viqbgrg.springboottesting.controller;

import com.github.viqbgrg.springboottesting.dto.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(LoginDto dto) {
        return ResponseEntity.ok().body(dto);
    }
}
