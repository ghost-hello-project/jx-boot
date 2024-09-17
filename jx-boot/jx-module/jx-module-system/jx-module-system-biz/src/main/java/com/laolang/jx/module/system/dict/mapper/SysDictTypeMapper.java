package com.laolang.jx.module.system.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laolang.jx.module.system.dict.dto.condition.SelectDictTypeListCondition;
import com.laolang.jx.module.system.dict.entity.SysDictType;
import java.util.List;

public interface SysDictTypeMapper extends BaseMapper<SysDictType> {
    List<SysDictType> selectDictTypeList(SelectDictTypeListCondition condition);
}
