package com.laolang.jx.module.auth.logic;

import com.google.common.collect.Sets;
import com.laolang.jx.framework.common.consts.DefaultStatusCode;
import com.laolang.jx.framework.common.util.JsonUtil;
import com.laolang.jx.module.auth.consts.AuthBizCode;
import com.laolang.jx.module.auth.context.AuthenticationContextHolder;
import com.laolang.jx.module.auth.dto.LoginUserDto;
import com.laolang.jx.module.auth.exception.BusinessAuthException;
import com.laolang.jx.module.auth.req.LoginReq;
import com.laolang.jx.module.auth.rsp.LoginRsp;
import com.laolang.jx.module.auth.rsp.UserInfoRsp;
import com.laolang.jx.module.auth.service.TokenService;
import com.laolang.jx.module.auth.util.AuthUtil;
import com.laolang.jx.module.system.dict.consts.SysUserLoginLogConsts;
import com.laolang.jx.module.system.dto.SysUserLoginLogInsertDto;
import com.laolang.jx.module.system.user.business.SysUserBusiness;
import com.laolang.jx.module.system.user.business.SysUserLoginLogBusiness;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthLogic {

    private final AuthenticationManager authenticationManager;
    private final SysUserLoginLogBusiness sysUserLoginLogBusiness;
    private final TokenService tokenService;
    private final AuthUtil authUtil;
    private final SysUserBusiness sysUserBusiness;

    public LoginRsp login(LoginReq req) {

        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
            AuthenticationContextHolder.setContext(authenticationToken);
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (Exception e) {
            if (e instanceof UsernameNotFoundException) {
                throw new BusinessAuthException(AuthBizCode.user_login_not_exist);
            } else if (e instanceof AccountExpiredException) {
                throw new BusinessAuthException(AuthBizCode.user_login_locked);
            } else if (e instanceof BadCredentialsException) {
                throw new BusinessAuthException(AuthBizCode.user_login_bad_credentials);
            } else {
                log.error("登录未知异常. req:{}", JsonUtil.toJson(req));
                throw new BusinessAuthException(DefaultStatusCode.FAILED.getMsg(), "登录失败");
            }
        } finally {
            AuthenticationContextHolder.clearContext();
        }

        LoginUserDto loginUserDto = (LoginUserDto) authentication.getPrincipal();

        // 生成 token
        String token = tokenService.createToken(loginUserDto);

        // 登录日志
        insertLoginLog(loginUserDto, req.getLoginType());

        LoginRsp rsp = new LoginRsp();
        rsp.setToken(token);
        return rsp;
    }

    // todo 异步 登录日志
    private void insertLoginLog(LoginUserDto dto, String loginType) {
        SysUserLoginLogInsertDto insertDto = new SysUserLoginLogInsertDto();
        insertDto.setUserId(dto.getSysUser().getId());
        insertDto.setTenantId(dto.getSysUser().getTenantId());
        insertDto.setLoginType(SysUserLoginLogConsts.LoginType.getByValue(loginType));
        insertDto.setLoginIp(dto.getSysUser().getLoginIp());
        sysUserLoginLogBusiness.insertLoginLog(insertDto);
    }

    public UserInfoRsp userInfo() {
        UserInfoRsp rsp = new UserInfoRsp();
        String username = authUtil.getAuthUser().getUsername();
        rsp.setUser(sysUserBusiness.getUserByUsername(username));
        rsp.setPerms(Sets.newHashSet("*:*:*"));
        rsp.setRoles(Sets.newHashSet("superAdmin"));
        return null;
    }
}
