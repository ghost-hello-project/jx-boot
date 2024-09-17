package com.laolang.jx.module.auth.handler;

import com.laolang.jx.framework.common.domain.R;
import com.laolang.jx.framework.common.util.JsonUtil;
import com.laolang.jx.framework.common.util.ServletKit;
import com.laolang.jx.module.auth.dto.LoginUserDto;
import com.laolang.jx.module.auth.service.TokenService;
import com.laolang.jx.module.system.api.dict.consts.SysUserLoginLogConsts;
import com.laolang.jx.module.system.api.user.SysUserLoginLogApi;
import com.laolang.jx.module.system.api.user.dto.SysUserLoginLogInsertDto;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@RequiredArgsConstructor
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    private final TokenService tokenService;
    private final SysUserLoginLogApi sysUserLoginLogApi;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUserDto loginUser = tokenService.getLoginUser(request);
        if (Objects.nonNull(loginUser)) {
            tokenService.removeToken(loginUser);
            SysUserLoginLogInsertDto insertDto = new SysUserLoginLogInsertDto();
            insertDto.setUserId(loginUser.getSysUser().getId());
            insertDto.setTenantId(loginUser.getSysUser().getTenantId());
            insertDto.setLoginType(SysUserLoginLogConsts.LoginType.logout);
            insertDto.setLoginIp(loginUser.getSysUser().getLoginIp());
            sysUserLoginLogApi.insertLoginLog(insertDto);
        }
        ServletKit.writeJson(response, JsonUtil.toJson(R.ok("退出成功")));
    }
}
