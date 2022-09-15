package com.github.viqbgrg.springboot.cache

import com.github.viqbgrg.springboot.cache.service.DataService
import com.github.viqbgrg.springboot.cache.service.HelloWorld
import org.spockframework.spring.SpringSpy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import javax.cache.CacheManager

@SpringBootTest
class HelloWorldTest extends spock.lang.Specification {

    @SpringSpy
    DataService dataService

    @Autowired
    HelloWorld helloWorld

    @Autowired
    CacheManager cacheManager


    def longToString() {
        given:
        Long value = 1L
        when:
        helloWorld.longToString(value)
        helloWorld.longToString(value)
        then:
        0 * dataService.longToString(value)
    }

    def cacheManagerTest() {
        expect:
        def cache = cacheManager.getCache("test", Long.class, String.class)
        def get = cache.get(1L)
        get != null
        def list = cache.asList()
        def value = list.get(0).getValue()
        value != null
    }
}