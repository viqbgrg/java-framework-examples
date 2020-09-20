package com.github.viqbgrg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class IocTest {
    ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
    }

    @Test
    void iocTest() {
        HelloWorld world = applicationContext.getBean("world", HelloWorld.class);
        world.say();
    }

    /**
     * 静态内部使用$符号
     */
    @Test
    void innerClassTest() {
        HelloWorld.InnerClass inner = applicationContext.getBean("inner", HelloWorld.InnerClass.class);
        System.out.println(inner.getName());

    }


}
