package com.github.viqbgrg.bootfeatures.externalconfig.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService implements MessageService {

    @Value("${name:World}")
    private String name;

    @Override
    public String getMessage() {
        return "Hello " + this.name;
    }

}