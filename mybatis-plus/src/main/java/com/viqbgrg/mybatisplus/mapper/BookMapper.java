package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viqbgrg.mybatisplus.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author bing
 * @since 2021-04-23
 */
@Mapper
@Repository
public interface BookMapper extends BaseMapper<Book> {
    List<Book> getBooks(int id);
}
