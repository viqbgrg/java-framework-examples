package com.github.viqbgrg.jackson.parsedeparse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

/**
 * @author hhj
 */
@Data
public class User {
    private String username;
    @JsonDeserialize(converter = MyConverter.class)
    private String roleId;
}
