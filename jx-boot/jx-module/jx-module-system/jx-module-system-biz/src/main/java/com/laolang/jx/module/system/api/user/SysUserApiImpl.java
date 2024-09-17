package com.laolang.jx.module.system.api.user;

import com.laolang.jx.module.system.api.user.pojo.SysUserPojo;
import com.laolang.jx.module.system.user.business.SysUserBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SysUserApiImpl implements SysUserApi {

    private final SysUserBusiness sysUserBusiness;


    @Override
    public SysUserPojo getUserByUsername(String username) {
        return sysUserBusiness.getUserByUsername(username);
    }
}
