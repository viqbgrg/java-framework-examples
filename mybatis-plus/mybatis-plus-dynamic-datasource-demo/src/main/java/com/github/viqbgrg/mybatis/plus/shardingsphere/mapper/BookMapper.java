package com.github.viqbgrg.mybatis.plus.shardingsphere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.viqbgrg.mybatis.plus.shardingsphere.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hhj
 */
@Mapper
@Repository
public interface BookMapper extends BaseMapper<Book> {
}
