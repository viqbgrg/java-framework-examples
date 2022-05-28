package com.github.viqbgrg.spockunittestdemo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Person {
    private String username;
    private String password;
    private int age;
    private BigDecimal amount;
}
