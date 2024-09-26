package com.laolang.jx.module.auth.controller;

import com.laolang.jx.framework.common.domain.R;
import com.laolang.jx.module.auth.logic.AuthLogic;
import com.laolang.jx.module.auth.req.LoginReq;
import com.laolang.jx.module.auth.rsp.LoginRsp;
import com.laolang.jx.module.auth.rsp.UserInfoRsp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("auth")
@RestController
public class AuthController {

    private final AuthLogic authLogic;

    @PostMapping("login")
    public R<LoginRsp> login(@RequestBody LoginReq req) {
        return R.ok(authLogic.login(req));
    }

    @GetMapping("userInfo")
    public R<UserInfoRsp> userInfo() {
        return R.ok(authLogic.userInfo());
    }

}
