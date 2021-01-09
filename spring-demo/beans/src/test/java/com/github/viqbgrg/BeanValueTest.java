package com.github.viqbgrg;

import com.github.viqbgrg.annotation.config.ValueConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class BeanValueTest {
    ApplicationContext applicationContext;

    /**
     * 从配置文件灵活的注入属性
     */
    @Test
    void testPro() {
        applicationContext = new AnnotationConfigApplicationContext(ValueConfig.class);
        String name = applicationContext.getBean("name", String.class);
        assertThat(name).isNotEmpty();
        com.github.viqbgrg.annotation.config.Person person = applicationContext.getBean("person", com.github.viqbgrg.annotation.config.Person.class);
        assertThat(person).isNotNull();
    }
}
