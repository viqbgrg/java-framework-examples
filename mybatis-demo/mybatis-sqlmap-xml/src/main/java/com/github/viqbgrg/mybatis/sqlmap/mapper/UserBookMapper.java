package com.github.viqbgrg.mybatis.sqlmap.mapper;

import com.github.viqbgrg.mybatis.sqlmap.entity.UserBook;

import java.util.List;

/**
 * @author bing
 */
public interface UserBookMapper {
    List<UserBook> selectAll();
}
