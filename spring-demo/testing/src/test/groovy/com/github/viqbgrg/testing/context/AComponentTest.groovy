package com.github.viqbgrg.testing.context

import spock.lang.Specification

class AComponentTest extends Specification {
    def "bean test"() {
        expect:
        print("111")
    }
}
