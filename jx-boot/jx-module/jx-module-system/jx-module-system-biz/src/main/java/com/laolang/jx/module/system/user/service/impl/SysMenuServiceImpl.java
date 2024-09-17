package com.laolang.jx.module.system.user.service.impl;

import com.laolang.jx.framework.mybatis.core.BaseServiceImpl;
import com.laolang.jx.module.system.user.entity.SysMenu;
import com.laolang.jx.module.system.user.mapper.SysMenuMapper;
import com.laolang.jx.module.system.user.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    private final SysMenuMapper sysMenuMapper;
}
