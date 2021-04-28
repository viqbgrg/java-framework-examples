package com.github.viqbgrg.mybatisplus.injectordemo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author miemie
 * @since 2018-08-13
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {
    /**
     * 自定义通用方法
     */
    List<T> selectAll();

}
