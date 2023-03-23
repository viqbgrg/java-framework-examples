package com.github.viqbgrg.spingdocdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.HashMap;

@Data
public class Result<T> {
    @Schema(description = "响应Code")
    private Integer code;
    @Schema(description = "响应描述")
    private String msg;
    @Schema(description = "响应内容")
    private T data;


    public Result() {
    }

    protected Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
