package com.github.viqbgrg.validation

import spock.lang.Specification

class UserTest extends Specification {

    def "not null"() {
        expect:
        def user = new User()
        user.setUsername(null)
    }
}
