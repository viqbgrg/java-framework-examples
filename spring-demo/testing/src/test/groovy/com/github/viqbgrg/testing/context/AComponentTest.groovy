package com.github.viqbgrg.testing.context

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = AComponent.class)
class AComponentTest extends Specification {
    @Autowired
    ApplicationContext applicationContext
    def "bean test"() {
        given:
        def bean = applicationContext.getBean(AComponent.class)
        def bComponent = applicationContext.getBean(BComponent.class)
        expect:
        bean != null
        bComponent == null
    }
}
