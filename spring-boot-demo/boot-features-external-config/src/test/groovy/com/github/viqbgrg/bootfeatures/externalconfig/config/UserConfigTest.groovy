package com.github.viqbgrg.bootfeatures.externalconfig.config

import com.github.viqbgrg.bootfeatures.externalconfig.entity.OneProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserConfigTest extends Specification {
    @Autowired
    OneProperties oneProperties

    def "测试是否有属于"() {
        expect:
        oneProperties.getA() != null
        oneProperties.getB() != null
    }
}
