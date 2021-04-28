package com.viqbgrg.mybatisplus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class StudentBook implements Serializable {


    /**
     * 学生ID
     */
    private Long studentId;

    /**
     * 书id
     */
    private Long bookId;


}
