package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viqbgrg.mybatisplus.entity.SequenceId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author bing
 * @since 2021-04-22
 */
@Mapper
@Repository
public interface SequenceIdMapper extends BaseMapper<SequenceId> {

}
