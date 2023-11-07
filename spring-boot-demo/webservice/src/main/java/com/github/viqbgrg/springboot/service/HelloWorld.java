package com.github.viqbgrg.springboot.service;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface HelloWorld {
    @WebMethod(operationName = "getHello")
    String sayHi(String text);
}
