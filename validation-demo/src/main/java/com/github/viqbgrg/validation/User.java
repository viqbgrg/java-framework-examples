package com.github.viqbgrg.validation;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author hhj
 */
@Data
public class User {
    @NotEmpty(message = "不能为空")
    private String username;
}
