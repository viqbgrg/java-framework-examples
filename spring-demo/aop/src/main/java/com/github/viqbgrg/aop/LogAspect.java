package com.github.viqbgrg.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.github.viqbgrg.aop.MyMath.add(..))")
    public void addPointCut() {

    }

    @Before("execution(* com.github.viqbgrg.aop.MyMath.add(..))")
    public void before() {
        log.info("方法执行");
    }

    @After("execution(* com.github.viqbgrg.aop.MyMath.add(..))")
    public void after() {
        log.info("方法结束");
    }

    @AfterReturning(pointcut = "execution(* com.github.viqbgrg.aop.MyMath.add(..))", returning = "val")
    public void afterReturning(Object val) {
        log.info("执行的结果是" + (int) val);
    }

    @Before("com.github.viqbgrg.aop.LogAspect.addPointCut()")
    public void addBefore() {
        log.info("切入点表达式");
    }
}
