package com.laolang.jx.module.system.user.service.impl;

import com.laolang.jx.framework.mybatis.core.BaseServiceImpl;
import com.laolang.jx.module.system.user.entity.SysUserLoginLog;
import com.laolang.jx.module.system.user.mapper.SysUserLoginLogMapper;
import com.laolang.jx.module.system.user.service.SysUserLoginLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SysUserLoginLogServiceImpl extends BaseServiceImpl<SysUserLoginLogMapper, SysUserLoginLog> implements SysUserLoginLogService {
    private final SysUserLoginLogMapper sysUserLoginLogMapper;
}
