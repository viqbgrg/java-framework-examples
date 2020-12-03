package com.github.viqbgrg.springboot.validator.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Person {
    @NotNull
    @Size(max = 64)
    private String name;

    @Min(0)
    private int age;
}
