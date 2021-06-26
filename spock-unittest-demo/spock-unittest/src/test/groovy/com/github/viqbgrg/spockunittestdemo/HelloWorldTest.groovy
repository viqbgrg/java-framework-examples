package com.github.viqbgrg.spockunittestdemo;

import spock.lang.Specification

class HelloWorldTest extends Specification {
     def hello = new HelloWorld()

    def "Add"() {
        expect:
        hello.add(a, b) == result
        where:
        a | b || result
        1 | 2 || 3
        1 | 3 || 4
    }

    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }
}
