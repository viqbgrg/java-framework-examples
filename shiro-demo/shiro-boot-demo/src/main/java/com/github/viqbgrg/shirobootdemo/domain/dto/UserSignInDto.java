package com.github.viqbgrg.shirobootdemo.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author hhj
 */
@Data
public class UserSignInDto {
    @NotEmpty(message = "邮箱不能为空")
    private String email;
    @NotEmpty(message = "密码不能为空")
    private String password;
}
