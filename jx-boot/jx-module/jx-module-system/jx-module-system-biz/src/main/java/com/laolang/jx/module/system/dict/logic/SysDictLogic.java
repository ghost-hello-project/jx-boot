package com.laolang.jx.module.system.dict.logic;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.laolang.jx.module.system.dict.dto.condition.SelectDictTypeListCondition;
import com.laolang.jx.module.system.dict.entity.SysDictType;
import com.laolang.jx.module.system.dict.req.SysDictTypeListReq;
import com.laolang.jx.module.system.dict.rsp.SysDictTypeListRsp;
import com.laolang.jx.module.system.dict.service.SysDictTypeService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SysDictLogic {

    private final SysDictTypeService sysDictTypeService;

    public SysDictTypeListRsp typeList(SysDictTypeListReq req) {
        SysDictTypeListRsp rsp = new SysDictTypeListRsp();

        SelectDictTypeListCondition condition = new SelectDictTypeListCondition();
        BeanUtils.copyProperties(req, condition);

        PageInfo<SysDictType> recordPageInfo = sysDictTypeService.selectDictTypeList(req.getPage(), req.getSize(), condition);
        if (CollUtil.isEmpty(recordPageInfo.getList())) {
            rsp.setPageInfo(new PageInfo<>());
            return rsp;
        }

        List<SysDictTypeListRsp.SysDictTypeListRspBean> beans = recordPageInfo.getList().stream().map(record -> {
            SysDictTypeListRsp.SysDictTypeListRspBean bean = new SysDictTypeListRsp.SysDictTypeListRspBean();
            BeanUtils.copyProperties(record, bean);
            return bean;
        }).collect(Collectors.toList());

        PageInfo<SysDictTypeListRsp.SysDictTypeListRspBean> pageInfo = new PageInfo<>(beans);
        pageInfo.setPageNum(recordPageInfo.getPageNum());
        pageInfo.setPages(recordPageInfo.getPageSize());
        pageInfo.setTotal(recordPageInfo.getTotal());
        pageInfo.setPages(recordPageInfo.getPages());

        rsp.setPageInfo(pageInfo);

        return rsp;
    }
}
