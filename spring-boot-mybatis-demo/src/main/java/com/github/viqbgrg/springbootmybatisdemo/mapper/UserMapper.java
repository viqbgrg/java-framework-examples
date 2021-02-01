package com.github.viqbgrg.springbootmybatisdemo.mapper;

import com.github.viqbgrg.springbootmybatisdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();
}
