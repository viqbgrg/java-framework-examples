package com.github.viqbgrg;

import lombok.Data;

/**
 * @author viqbgrg
 */
@Data
public class Person {
    private String name;
    private Book book;

    public Person(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}
