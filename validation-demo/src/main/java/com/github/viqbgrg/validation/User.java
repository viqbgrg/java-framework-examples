package com.github.viqbgrg.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author hhj
 */
@Data
@AllArgsConstructor
public class User {
    /**
     * empty 空字符串 长度为 0
     * blank 空格字符串
     */
    @NotEmpty(message = "不能为 empty")
    private String emptyString;
    @NotNull(message = "不能为 null")
    private String nullString;
    @NotBlank(message = "不能为 blank")
    private String blankString;
}
