package com.viqbgrg.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author bing
 * @since 2021-04-22
 */
@Data
@TableName(value = "sequence_id")
@KeySequence(value = "key_generator_model_seq")
public class SequenceId implements Serializable {


    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    private String name;
}
