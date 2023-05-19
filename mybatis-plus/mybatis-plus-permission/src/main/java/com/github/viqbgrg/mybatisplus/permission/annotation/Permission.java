package com.github.viqbgrg.mybatisplus.permission.annotation;

import com.github.viqbgrg.mybatisplus.permission.PermissionType;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    PermissionType value();
}
