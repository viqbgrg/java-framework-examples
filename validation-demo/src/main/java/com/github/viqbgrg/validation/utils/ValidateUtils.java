package com.github.viqbgrg.validation.utils;

import com.github.viqbgrg.validation.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class ValidateUtils {

    public T ConstraintViolation<T> getValidate(T a){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // 2、得到一个校验器
        Validator validator = validatorFactory.getValidator();
        // 3、校验Java Bean（解析注解） 返回校验结果
        Set<ConstraintViolation<T>> result = validator.validate(a);
        result null;
    }
}
