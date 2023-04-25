package com.github.viqbgrg.validation

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory
import spock.lang.Specification

class UserTest extends Specification {

    def "not null"() {
        expect:
        def user = new User()
        user.setUsername(null)
        // 1、使用【默认配置】得到一个校验工厂  这个配置可以来自于provider、SPI提供
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // 2、得到一个校验器
        Validator validator = validatorFactory.getValidator()
        // 3、校验Java Bean（解析注解） 返回校验结果
        Set<ConstraintViolation<User>> result = validator.validate(user)
        // 输出校验结果
        result.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue()).forEach(System.out::println);
    }
}
