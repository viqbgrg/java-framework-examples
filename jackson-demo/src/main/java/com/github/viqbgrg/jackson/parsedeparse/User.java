package com.github.viqbgrg.jackson.parsedeparse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author hhj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    @JsonDeserialize(converter = MyConverter.class)
    private Integer roleId;
    @JsonDeserialize(using = MyConverter1.class)
    private Integer sex;
}
