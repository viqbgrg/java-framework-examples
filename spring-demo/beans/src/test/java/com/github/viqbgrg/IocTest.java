package com.github.viqbgrg;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {

    @Test
    void iocTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        HelloWorld world = applicationContext.getBean("world", HelloWorld.class);
        world.say();
    }
}
