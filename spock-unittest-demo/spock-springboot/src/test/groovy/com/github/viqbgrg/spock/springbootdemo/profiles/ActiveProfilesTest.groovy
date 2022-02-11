package com.github.viqbgrg.spock.springbootdemo.profiles

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class ActiveProfilesTest extends Specification{
    @Value('${name}')
    String name

    def "print name"() {
        expect: "打印配置文件中的值"
        name == "小明"
    }
}
