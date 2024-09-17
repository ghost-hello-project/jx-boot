package com.laolang.jx.module.system.user.business;

import com.laolang.jx.framework.common.consts.CommonEntityConsts;
import com.laolang.jx.module.system.api.user.pojo.SysUserPojo;
import com.laolang.jx.module.system.user.entity.SysTenant;
import com.laolang.jx.module.system.user.entity.SysUser;
import com.laolang.jx.module.system.user.service.SysTenantService;
import com.laolang.jx.module.system.user.service.SysUserService;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SysUserBusiness {

    private final SysUserService sysUserService;
    private final SysTenantService sysTenantService;

    public SysUserPojo getUserByUsername(String username) {
        SysUser sysUser = sysUserService.getUserByUsername(username);
        if (Objects.isNull(sysUser)) {
            return null;
        }

        SysTenant sysTenant = sysTenantService.getById(sysUser.getTenantId());
        if (Objects.isNull(sysTenant)) {
            return null;
        }

        if (sysTenant.getStartTime().isAfter(LocalDateTime.now()) || sysTenant.getEndTime().isBefore(LocalDateTime.now())) {
            sysUser.setStatus(CommonEntityConsts.Status.STOP.getValue());
        } else {
            sysUser.setStatus(sysTenant.getStatus());
        }

        SysUserPojo pojo = new SysUserPojo();
        BeanUtils.copyProperties(sysUser, pojo);

        return pojo;
    }
}
