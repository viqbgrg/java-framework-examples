package com.github.viqbgrg.spingdocdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Dog",description = "狗实体")
public class Dog {
    @Schema(description = "名字")
    private String name;
}
