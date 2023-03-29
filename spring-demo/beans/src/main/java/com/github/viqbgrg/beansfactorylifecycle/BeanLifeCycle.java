package com.github.viqbgrg.beansfactorylifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BeanLifeCycle {
    public BeanLifeCycle() {
        System.out.println("构造器执行");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化执行");
    }

    @PreDestroy
    public void detory() {
        System.out.println("销毁执行");
    }

    public void print() {
        System.out.println("方法执行");
    }
}
