package com.laolang.jx.module.system.user.service.impl;

import com.laolang.jx.framework.mybatis.core.BaseServiceImpl;
import com.laolang.jx.module.system.user.entity.SysTenant;
import com.laolang.jx.module.system.user.mapper.SysTenantMapper;
import com.laolang.jx.module.system.user.service.SysTenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SysTenantServiceImpl extends BaseServiceImpl<SysTenantMapper, SysTenant> implements SysTenantService {
    private final SysTenantMapper sysTenantMapper;
}
