package com.laolang.jx.module.auth.req;

import lombok.Data;

@Data
public class LoginReq {

    private String username;
    private String password;
    private String loginType;
}
