package com.github.viqbgrg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

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

    // 构造函数实例化
    @Test
    void constructorTest() {
        HelloWorld constructor = applicationContext.getBean("constructor", HelloWorld.class);
        assertThat(constructor.say()).isEqualTo("Hello haha");
    }

    // 用静态工厂方法实例化
    @Test
    void staticFactoryTest() {
        HelloWorld staticFactory = applicationContext.getBean("staticFactory", HelloWorld.class);
        assertThat(staticFactory.say()).isEqualTo("Hello staticFactory");
    }

    // 用实例工厂方法实例化
    @Test
    void noStaticFactory() {
        HelloWorld staticFactory = applicationContext.getBean("noStaticFactory", HelloWorld.class);
        assertThat(staticFactory.say()).isEqualTo("Hello noStaticFactory");
    }
    // 确定 Bean 的运行时类型

}
