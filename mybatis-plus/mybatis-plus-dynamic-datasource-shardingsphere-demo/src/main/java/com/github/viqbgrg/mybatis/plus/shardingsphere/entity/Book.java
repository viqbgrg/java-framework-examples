package com.github.viqbgrg.mybatis.plus.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author hhj
 */
@Data
public class Book {
    @TableId(value = "id", type = IdType.INPUT)
    private int id;
    private String name;
}
