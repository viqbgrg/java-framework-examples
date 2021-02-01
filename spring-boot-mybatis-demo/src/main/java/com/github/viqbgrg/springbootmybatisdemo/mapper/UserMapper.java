package com.github.viqbgrg.springbootmybatisdemo.mapper;

import com.github.viqbgrg.springbootmybatisdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectAll();
}
