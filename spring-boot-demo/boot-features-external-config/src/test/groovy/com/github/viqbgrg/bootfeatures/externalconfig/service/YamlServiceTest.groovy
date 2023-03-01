package com.github.viqbgrg.bootfeatures.externalconfig.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class YamlServiceTest extends Specification {
    @Autowired
    YamlService yamlService

    def "GetYamlAValue"() {
        expect:
        yamlService.getYamlAValue() == 'hello'
    }
}
