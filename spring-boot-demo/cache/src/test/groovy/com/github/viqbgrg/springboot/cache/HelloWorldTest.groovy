package com.github.viqbgrg.springboot.cache

import com.github.viqbgrg.springboot.cache.service.DataService
import com.github.viqbgrg.springboot.cache.service.HelloWorld
import org.spockframework.spring.SpringSpy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HelloWorldTest extends spock.lang.Specification {

    @SpringSpy
    DataService dataService

    @Autowired
    HelloWorld helloWorld


    def longToString() {
        given:
        Long value = 1L
        when:
        helloWorld.longToString(value)
        helloWorld.longToString(value)
        then:
        0 * dataService.longToString(value)
    }
}