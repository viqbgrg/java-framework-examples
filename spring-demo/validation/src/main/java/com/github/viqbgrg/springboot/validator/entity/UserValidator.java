package com.github.viqbgrg.springboot.validator.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author viqbgrg
 */
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", "用户名不能为空");
        User user = (User) target;
        if (user.getUsername().length() < 6) {
            errors.rejectValue("username", "用户名不能低于6位");
        } else if (user.getPassword().length() < 6) {
            errors.rejectValue("password", "密码不能低于6位");
        }
    }
}
