package com.github.viqbgrg.spingdocdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Person",description = "人实体")
public class Person {
    @Schema(description = "名字")
    private String name;

    @Schema(description = "年龄")
    private Integer age;
}
