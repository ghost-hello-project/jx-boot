package com.laolang.jx.module.auth.util;

import cn.hutool.core.util.StrUtil;
import com.laolang.jx.framework.common.consts.GlobalConst;
import com.laolang.jx.module.auth.consts.AuthBizCode;
import com.laolang.jx.module.auth.domain.AuthUser;
import com.laolang.jx.module.auth.dto.LoginUserDto;
import com.laolang.jx.module.auth.exception.BusinessAuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthUtil {
    
    public boolean isSuperAdmin(String username) {
        return StrUtil.equals(GlobalConst.ADMIN_ACCOUNT, username);
    }

    
    public Long getLoginId() {
        try {
            return getLoginUser().getSysUser().getId();
        } catch (Exception e) {
            throw new BusinessAuthException(AuthBizCode.auth_getuser_failed);
        }
    }

    
    public Long getTenantId() {
        try {
            return getLoginUser().getSysUser().getTenantId();
        } catch (Exception e) {
            throw new BusinessAuthException(AuthBizCode.auth_getuser_failed);
        }
    }

    
    public AuthUser getAuthUser() {
        try {
            LoginUserDto loginUser = getLoginUser();
            AuthUser authUser = new AuthUser();
            authUser.setUserId(loginUser.getSysUser().getId());
            authUser.setTenantId(loginUser.getSysUser().getTenantId());
            authUser.setUsername(loginUser.getSysUser().getUsername());
            authUser.setPhone(loginUser.getSysUser().getPhone());
            authUser.setPerms(loginUser.getPerms());
            authUser.setRole(loginUser.getRole());
            return authUser;
        } catch (Exception e) {
            throw new BusinessAuthException(AuthBizCode.auth_getuser_failed);
        }
    }

    public LoginUserDto getLoginUser() {
        try {
            return (LoginUserDto) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new BusinessAuthException(AuthBizCode.auth_getuser_failed);
        }
    }

    
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
