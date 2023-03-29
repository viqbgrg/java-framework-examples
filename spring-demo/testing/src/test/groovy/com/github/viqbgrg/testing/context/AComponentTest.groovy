package com.github.viqbgrg.testing.context

class AComponentTest extends spock.lang.Specification {
    def "bean test"() {
        expect:
        print("111")
    }
}
