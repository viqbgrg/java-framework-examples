package com.github.viqbgrg.plugins.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hhj
 */
@Data
public class User {
    private long id;
    private String username;
    private String password;
    private int locked;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
