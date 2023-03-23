package com.github.viqbgrg.spingdocdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification
@SpringBootTest
class SpingdocDemoApplicationTest extends Specification {

    @Autowired
    ApplicationContext context


    def "Main"() {
        expect:
        context != null
    }
}
