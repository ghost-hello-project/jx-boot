package com.laolang.jx.module.system.dict.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laolang.jx.framework.mybatis.core.BaseServiceImpl;
import com.laolang.jx.module.system.dict.dto.condition.SelectDictTypeListCondition;
import com.laolang.jx.module.system.dict.entity.SysDictType;
import com.laolang.jx.module.system.dict.mapper.SysDictTypeMapper;
import com.laolang.jx.module.system.dict.service.SysDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SysDictTypeServiceImpl extends BaseServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {
    private final SysDictTypeMapper sysDictTypeMapper;

    @Override
    public PageInfo<SysDictType> selectDictTypeList(Integer page, Integer size, SelectDictTypeListCondition condition) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(sysDictTypeMapper.selectDictTypeList(condition));
    }
}
