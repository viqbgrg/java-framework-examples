package com.github.viqbgrg.spockunittestdemo

import com.github.viqbgrg.spockunittestdemo.entity.Person
import spock.lang.Specification


class MockAndTest extends Specification {

    /**
     * mock 多次使用 and 隔开
     */
    def "mock 多次"() {
        given:
        def person = Mock(Person)
        when:
        person.getUsername() >> "小明"
        then:
        person.getUsername() == "小明"
        when:
        person.getUsername() >> "哈哈"
        then:
        person.getUsername() == "哈哈"
    }
}