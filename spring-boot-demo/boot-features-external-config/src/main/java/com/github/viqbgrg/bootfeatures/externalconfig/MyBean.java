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

    @Value("${my.secret}")
    private String secret;

    @Value("${my.number}")
    private String number;

    @Value("${test-string.value}")
    private String testString;

    @Value("${test-default.value:world}")
    private String defaultString;

    @Bean
    public String name() {
        log.info("name=" + this.name);
        return this.name;
    }


    @Bean
    public String secret() {
        log.info("secret=" + this.secret);
        return this.secret;
    }


    @Bean
    public String number() {
        log.info("number=" + this.number);
        return this.number;
    }

    @Bean
    public String testString() {
        return this.testString;
    }

    @Bean
    public String defaultString() {
        return this.defaultString;
    }

}