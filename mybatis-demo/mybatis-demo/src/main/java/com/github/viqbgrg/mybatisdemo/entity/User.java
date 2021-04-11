package com.github.viqbgrg.mybatisdemo.entity;

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
    private Sex sex;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
