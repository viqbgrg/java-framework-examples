package com.github.viqbgrg.swaggerdemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author hhj
 */
@Data
@ApiModel(value = "登录信息", description = "测试")
public class TestDto {
    @ApiModelProperty(value = "用户名", required = true)
    @NotNull(message = "用户名不能为空")
    @Size(min = 4, max = 15)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotNull
    @Size(min = 4, max = 15)
    private String password;
}
