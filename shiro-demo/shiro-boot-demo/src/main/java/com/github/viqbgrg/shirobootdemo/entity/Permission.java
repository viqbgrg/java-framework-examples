package com.github.viqbgrg.shirobootdemo.entity;

import lombok.Data;

/**
 * @author hhj
 */
@Data
public class Permission {
    private Long id;
    private String permission;
    private String description;
    private Boolean available = Boolean.FALSE;
}
