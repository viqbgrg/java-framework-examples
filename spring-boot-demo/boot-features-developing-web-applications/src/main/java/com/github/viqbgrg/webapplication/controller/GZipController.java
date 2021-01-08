package com.github.viqbgrg.webapplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

@RestController
@RequestMapping
public class GZipController {
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/nogzip")
    public ResponseEntity<User> nogzip(HttpServletResponse response) throws IOException {
        User user = new User();
        user.setUsername("xiaoming");
        user.setEmail("123@qq.com");
        return ResponseEntity.ok(user);
    }

    @GetMapping("/gzip")
    public void gzip(HttpServletResponse response) throws IOException {
        User user = new User();
        user.setUsername("xiaoming");
        user.setEmail("123@qq.com");
        response.addHeader("Content-Encoding", "gzip");
        response.addHeader("Content-Type", "application/json");
        OutputStream out = response.getOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(out);
        gzipOutputStream.write(objectMapper.writeValueAsBytes(user));
        gzipOutputStream.close();
    }

    @Data
    static class User {
        private String username;
        private String email;
    }
}

