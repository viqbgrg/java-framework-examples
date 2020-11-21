package com.github.viqbgrg.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AroundExample {

    @Around("execution(* com.github.viqbgrg.aop.MyMath.jian(..))")
    public Object jian(ProceedingJoinPoint pjp) throws Throwable {
        log.info("减法开始执行");
        Object proceed = pjp.proceed();
        log.info("减法执行结束");
        return proceed;
    }

}
