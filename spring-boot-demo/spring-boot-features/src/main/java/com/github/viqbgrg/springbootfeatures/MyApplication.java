package com.github.viqbgrg.springbootfeatures;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        // 放入 banner.txt 实现自定义 banner
        SpringApplication.run(MyApplication.class, args);
    }
}
