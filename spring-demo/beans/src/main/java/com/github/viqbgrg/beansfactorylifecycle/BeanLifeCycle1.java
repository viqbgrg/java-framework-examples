package com.github.viqbgrg.beansfactorylifecycle;

public class BeanLifeCycle1 {
    public BeanLifeCycle1() {
        System.out.println("构造器执行");
    }

    public void init() {
        System.out.println("初始化执行");
    }

    public void detory() {
        System.out.println("销毁执行");
    }

    public void print() {
        System.out.println("方法执行");
    }
}
