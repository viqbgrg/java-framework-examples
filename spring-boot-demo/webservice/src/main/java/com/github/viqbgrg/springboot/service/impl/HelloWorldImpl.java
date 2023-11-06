package com.github.viqbgrg.springboot.service.impl;

import com.github.viqbgrg.springboot.service.HelloWorld;
import jakarta.jws.WebService;

@WebService(endpointInterface = "com.github.viqbgrg.springboot.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}