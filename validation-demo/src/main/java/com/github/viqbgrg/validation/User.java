package com.github.viqbgrg.validation;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


/**
 * @author hhj
 */
@Data
public class User {
    @NotEmpty(message = "不能为空")
    private String username;
}
