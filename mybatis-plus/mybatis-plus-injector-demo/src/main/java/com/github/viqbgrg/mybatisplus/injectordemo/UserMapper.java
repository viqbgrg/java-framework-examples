package com.github.viqbgrg.mybatisplus.injectordemo;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author miemie
 * @since 2018-08-12
 */
@Repository
@Mapper
public interface UserMapper extends MyBaseMapper<User> {


}
