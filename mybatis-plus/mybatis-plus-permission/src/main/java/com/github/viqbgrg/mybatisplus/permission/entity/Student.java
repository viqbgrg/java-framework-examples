package com.github.viqbgrg.mybatisplus.permission.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.viqbgrg.mybatisplus.permission.PermissionType;
import com.github.viqbgrg.mybatisplus.permission.annotation.Permission;
import lombok.Data;

@Data
public class Student {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 姓名
     */
    private String name;
    @Permission(PermissionType.GRADE)
    private Integer grade;

    @Permission(PermissionType.CLASS)
    private Long classId;

    @TableField(exist = false)
    private String className;
}
