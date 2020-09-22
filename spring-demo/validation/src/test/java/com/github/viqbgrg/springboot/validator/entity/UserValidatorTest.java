package com.github.viqbgrg.springboot.validator.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;


@SpringBootTest
class UserValidatorTest {
    @Test
    void testValidator() {
        User user = new User();
        user.setUsername("111");
        user.setPassword("111");
        DataBinder binder = new DataBinder(user);
        binder.setValidator(new UserValidator());
        BindingResult results = binder.getBindingResult();
        System.out.println(results);
    }

}