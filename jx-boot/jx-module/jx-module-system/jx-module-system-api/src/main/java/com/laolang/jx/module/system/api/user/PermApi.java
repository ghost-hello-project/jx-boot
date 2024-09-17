package com.laolang.jx.module.system.api.user;

import java.util.Set;

public interface PermApi {

    Set<String> selectPersmByUsername(String username);
}
