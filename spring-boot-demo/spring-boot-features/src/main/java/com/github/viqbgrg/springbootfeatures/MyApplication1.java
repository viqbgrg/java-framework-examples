package com.github.viqbgrg.springbootfeatures;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication1 {
    public static void main(String[] args) {
        // 使用自定义的 springapplication 启动
        SpringApplication springApplication = new SpringApplication(MyApplication1.class);
        // 关闭横幅
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
