package com.github.viqbgrg.jackson.parsedeparse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
