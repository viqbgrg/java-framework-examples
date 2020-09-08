package com.github.viqbgrg.bootfeatures.externalconfig;

import com.github.viqbgrg.bootfeatures.externalconfig.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

    @Autowired
    private MessageService helloWorldService;


    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.helloWorldService.getMessage());
    }
}
