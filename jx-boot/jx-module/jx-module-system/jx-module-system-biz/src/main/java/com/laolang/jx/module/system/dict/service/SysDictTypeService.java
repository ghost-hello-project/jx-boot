package com.laolang.jx.module.system.dict.service;

import com.github.pagehelper.PageInfo;
import com.laolang.jx.framework.mybatis.core.BaseService;
import com.laolang.jx.module.system.dict.dto.condition.SelectDictTypeListCondition;
import com.laolang.jx.module.system.dict.entity.SysDictType;

public interface SysDictTypeService extends BaseService<SysDictType> {
    PageInfo<SysDictType> selectDictTypeList(Integer page, Integer size, SelectDictTypeListCondition condition);
}
