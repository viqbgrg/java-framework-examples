package com.github.viqbgrg.webapplication.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GZipController {
    @GetMapping("/gzip")
    public ResponseEntity<User> gzip() {
        User user = new User();
        user.setUsername("xiaoming");
        user.setEmail("123@qq.com");
        return ResponseEntity.ok(user);
    }

    @Data
    static class User {
        private String username;
        private String email;
    }
}
