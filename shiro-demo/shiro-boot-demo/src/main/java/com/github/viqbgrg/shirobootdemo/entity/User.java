package com.github.viqbgrg.shirobootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author hhj
 */
@Data
public class User {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private long id;
    private String email;
    private String password;
    private Boolean locked;
}
