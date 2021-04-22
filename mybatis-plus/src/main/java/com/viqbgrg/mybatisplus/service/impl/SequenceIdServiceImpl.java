package com.viqbgrg.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.viqbgrg.mybatisplus.entity.SequenceId;
import com.viqbgrg.mybatisplus.mapper.SequenceIdMapper;
import com.viqbgrg.mybatisplus.service.ISequenceIdService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bing
 * @since 2021-04-22
 */
@Service
public class SequenceIdServiceImpl extends ServiceImpl<SequenceIdMapper, SequenceId> implements ISequenceIdService {

}
