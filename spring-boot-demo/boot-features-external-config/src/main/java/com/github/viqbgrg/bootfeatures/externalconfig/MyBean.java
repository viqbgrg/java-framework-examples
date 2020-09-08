package com.github.viqbgrg.bootfeatures.externalconfig;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Log
@Component
public class MyBean {

    @Value("${name}")
    private String name;

    @Bean
    public String name() {
        log.info("name=" + this.name);
        return this.name;
    }

}