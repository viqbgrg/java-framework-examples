package com.viqbgrg.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viqbgrg.mybatisplus.model.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author bing
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {


    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    @TableField(exist = false)
    private List<Book> books;
}
