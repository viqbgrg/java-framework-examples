package com.github.viqbgrg.mybatisplus.permission.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.viqbgrg.mybatisplus.permission.PermissionType;
import com.github.viqbgrg.mybatisplus.permission.annotation.Permission;
import lombok.Data;

@Data
public class TClass {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    @Permission(value = PermissionType.GRADE)
    private Integer grade;

    private String className;
}
