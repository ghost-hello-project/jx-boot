package com.laolang.jx.module.auth.service;

import cn.hutool.core.util.StrUtil;
import com.laolang.jx.framework.common.consts.CommonEntityConsts;
import com.laolang.jx.module.auth.consts.AuthBizCode;
import com.laolang.jx.module.auth.dto.LoginUserDto;
import com.laolang.jx.module.system.user.business.SysUserBusiness;
import com.laolang.jx.module.system.user.entity.SysUser;
import java.util.Objects;
import javax.security.auth.login.AccountExpiredException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SysUserBusiness sysUserBusiness;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUserPojo = sysUserBusiness.getUserByUsername(username);

        // 用户不存在
        if (Objects.isNull(sysUserPojo)) {
            throw new UsernameNotFoundException(AuthBizCode.user_login_not_exist.getMsg());
        }

        // 被锁定
        if (StrUtil.equals(sysUserPojo.getStatus(), CommonEntityConsts.Status.STOP.getValue())) {
            throw new AccountExpiredException(AuthBizCode.user_login_locked.getMsg());
        }

        return new LoginUserDto(sysUserPojo);
    }
}
