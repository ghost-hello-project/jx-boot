package com.laolang.jx.module.auth.api.domain;

import com.laolang.jx.framework.common.enums.PlatformTypeEnum;
import java.util.Set;
import lombok.Data;

@Data
public class AuthUser {

    private Long userId;
    private Long tenantId;
    private String username;
    private String phone;
    private Set<String> perms;
    private Set<String> role;
    private PlatformTypeEnum platformType;
}
