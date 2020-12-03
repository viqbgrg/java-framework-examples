package com.github.viqbgrg.junitdemo.base;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * all
 * each
 * Hello World
 * each
 * 你好
 * all 首先执行,只执行一次
 * each 执行每个方法都会执行他一次
 */
public class BeforeTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("each");
    }

    @Test
    void firstTest() {
        System.out.println("Hello World");
    }


    @Test
    void secondTest() {
        System.out.println("你好");
    }
}
