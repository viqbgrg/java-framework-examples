package com.github.viqbgrg.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyMath {

    public int add(int a, int b) {
        log.info("加法运行");
        return a + b;
    }

    public int jian(int a, int b) {
        return a - b;
    }
}
