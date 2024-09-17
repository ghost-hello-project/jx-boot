package com.laolang.jx.module.auth.api;

import com.laolang.jx.module.auth.api.domain.AuthUser;
import org.springframework.security.core.Authentication;

public interface AuthApi {
    boolean isSuperAdmin(String username);

    Long getLoginId();

    Long getTenantId();

    AuthUser getAuthUser();

    Authentication getAuthentication();
}
