package com.github.viqbgrg.mybatis.sqlmap.mapper;

import com.github.viqbgrg.mybatis.sqlmap.entity.User;
import com.github.viqbgrg.mybatis.sqlmap.entity.UserBook;

import java.util.List;

/**
 * @author bing
 */
public interface UserMapper {
    List<User> selectUserAndBookId();
}
