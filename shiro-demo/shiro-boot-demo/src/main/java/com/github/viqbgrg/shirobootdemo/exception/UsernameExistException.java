package com.github.viqbgrg.shirobootdemo.exception;

import static java.lang.String.format;

/**
 * @author hhj
 */
public class UsernameExistException extends RuntimeException {
    public UsernameExistException(String username) {
        super(format("用户名%s已注册", username));
    }
}
