package com.github.viqbgrg.springboot.service;


import jakarta.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}
