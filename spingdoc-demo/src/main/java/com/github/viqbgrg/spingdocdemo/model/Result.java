package com.github.viqbgrg.spingdocdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Result",description = "API响应实体")
public class Result<T> {
    @Schema(description = "响应Code")
    private int code;
    @Schema(description = "响应描述")
    private String msg;
    @Schema(description = "响应内容")
    private T data;
}
