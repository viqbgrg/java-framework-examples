package com.github.viqbgrg.logdemo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {
    Logger logger = LoggerFactory.getLogger("chapters.introduction.HelloWorld2");
    @Test
    void helloWorld() {

        logger.debug("Hello world.");

        // print internal state
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        StatusPrinter.print(lc);
    }

    /**
     * 占位符
     */
    @Test
    void zhan(){
        logger.info("我是{}", "占位符");
    }
}