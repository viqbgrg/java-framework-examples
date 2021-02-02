package com.github.viqbgrg.springbootmybatisdemo.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long id;
    private String name;
    private List<Integer> income;
    private Car car;
}
