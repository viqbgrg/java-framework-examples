package com.github.viqbgrg.aop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AopTest {

    public static AnnotationConfigApplicationContext annotationConfigApplicationContext;

    @BeforeAll
    void before() {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    void testApplicationContext() {
        Assertions.assertThat(annotationConfigApplicationContext).isNotNull();
    }

    @Test
    void testAop() {
        MyMath bean = annotationConfigApplicationContext.getBean(MyMath.class);
        bean.add(1, 2);
    }


    @Test
    void testAround() {
        MyMath bean = annotationConfigApplicationContext.getBean(MyMath.class);
        bean.jian(1, 2);
    }
}
