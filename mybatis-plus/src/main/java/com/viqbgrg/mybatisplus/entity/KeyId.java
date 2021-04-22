package com.viqbgrg.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = false)
public class KeyId implements Serializable {


    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;


}
