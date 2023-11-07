package com.github.viqbgrg.springboot.config

import com.github.viqbgrg.springboot.service.HelloWorld
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ClientTest extends Specification {
    @Autowired
    HelloWorld client

    def "clientTest"() {
        expect:
        client.sayHi("哈哈")
    }
}
