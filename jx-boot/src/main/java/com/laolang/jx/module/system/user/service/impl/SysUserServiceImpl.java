package com.laolang.jx.module.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.laolang.jx.framework.mybatis.consts.SqlConsts;
import com.laolang.jx.framework.mybatis.core.BaseServiceImpl;
import com.laolang.jx.module.system.user.entity.SysUser;
import com.laolang.jx.module.system.user.mapper.SysUserMapper;
import com.laolang.jx.module.system.user.service.SysUserService;
import java.sql.Wrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    private final SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByUsername(String username) {
        LambdaQueryWrapper<SysUser> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(SysUser::getUsername,username)
                .last(SqlConsts.LIMIT_1);
        return getOne(wrapper);
    }
}
