package com.github.viqbgrg.validation.utils

import com.github.viqbgrg.validation.User
import spock.lang.Specification

class ValidateUtilsTest extends Specification {
    def "validate"() {
        expect:
        def validate = ValidateUtils.getValidate(user)
        validate.forEach { it ->
            {
                println it.getMessage()
            }
        }
        validate.size() == size
        where:
        user                    | size
        new User(" ", null, "") | 2
        new User("", null, " ") | 3
        new User(null, null, " ") | 3
    }
}
