package com.github.viqbgrg.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @author hhj
 */
@Data
public class User {
    @NotEmpty(message = "不能为empty")
    private String emptyString;
    @NotNull(message = "不能为null")
    private String nullString;
    @NotBlank(message = "不能为 blank")
    private String blankString;
}
