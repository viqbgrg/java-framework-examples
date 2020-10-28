package com.github.viqbgrg;

import com.github.viqbgrg.idref.Bean2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
    void noStaticFactoryTest() {
        HelloWorld staticFactory = applicationContext.getBean("noStaticFactory", HelloWorld.class);
        assertThat(staticFactory.say()).isEqualTo("Hello noStaticFactory");
    }

    // 确定 Bean 的运行时类型
    @Test
    void beanTypeTest() {
        Class<?> constructor = applicationContext.getType("constructor");
        System.out.println(constructor.getName());
        assertThat(constructor.getName()).isEqualTo("com.github.viqbgrg.HelloWorld");
    }

    // 构造函数参数注入
    @Test
    void constructorDITest() {
        Person person = getPerson("person");
        assertThat(person.getName()).isEqualTo("xiaoming");
        assertThat(person.getBook().getBookName()).isEqualTo("从入门到跑路");
    }

    // 构造函数-type
    @Test
    void typeDITest() {
        Person personByType = getPerson("personByType");
        assertThat(personByType.getName()).isEqualTo("type");
        assertThat(personByType.getAge()).isEqualTo(1);
    }

    // 构造函数-index
    @Test
    void indexDITest() {
        Person personByIndex = getPerson("personByIndex");
        assertThat(personByIndex.getName()).isNotEmpty();
        assertThat(personByIndex.getAge()).isNotNull();
    }

    // 构造函数-name
    // 如果报错尝@ConstructorProperties({"years", "ultimateAnswer"})
    @Test
    void nameDITest() {
        Person personByName = getPerson("personByName");
        assertThat(personByName.getAge()).isEqualTo(1);
        assertThat(personByName.getName()).isEqualTo("name");
    }


    private Person getPerson(String beanName) {
        return this.applicationContext.getBean(beanName, Person.class);
    }

    // 循环依赖
    @Test
    void circleException() {
        assertThatExceptionOfType(BeanCreationException.class).isThrownBy(() -> {
            new ClassPathXmlApplicationContext("ioc1.xml");
        });
    }

    // 尝试使用setter解决循环依赖
    @Test
    void circleBySetter() {
        CircleB circleB = applicationContext.getBean("circleB", CircleB.class);
        assertThat(circleB.getCircleA()).isNotNull();
    }

    @Test
    void idrefTest() {
        Bean2 bean2 = applicationContext.getBean("bean2", Bean2.class);
        bean2.test();
    }

    // 在bean内部定义一个bean
    @Test
    void personInnerBookTest() {
        Person personInnerBook = applicationContext.getBean("personInnerBook", Person.class);
        assertThat(personInnerBook.getBook().getBookName()).isEqualTo("mybook");

    }

}
