package com.github.viqbgrg;

import com.github.viqbgrg.beansfactorylifecycle.BeanLifeCycle;
import com.github.viqbgrg.beansfactorylifecycle.BeanLifeCycle1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCycleTest {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new ClassPathXmlApplicationContext("beancycle.xml");
    }

    @Test
    void initTest() {
        BeanLifeCycle cycle1 = applicationContext.getBean("cycle1", BeanLifeCycle.class);
        cycle1.print();
    }

    @Test
    void initTest1() {
        BeanLifeCycle1 cycle = applicationContext.getBean("cycle2", BeanLifeCycle1.class);
        cycle.print();

    }

    @AfterEach
    void after() {
        applicationContext.registerShutdownHook();
    }
}
