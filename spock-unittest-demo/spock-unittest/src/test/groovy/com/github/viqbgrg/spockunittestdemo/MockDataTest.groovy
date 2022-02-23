package com.github.viqbgrg.spockunittestdemo

import com.github.viqbgrg.spockunittestdemo.entity.Person
import spock.lang.Specification

class MockDataTest extends Specification {

    def "mock data"() {
        given:
        def person = new Person(username: "小明");
        def personList = new ArrayList<Person>()
        personList << person
        expect:
        person.getUsername() == "小明"
        personList.size() == 1
        personList[0].getUsername() == "小明"
    }
}
