package com.laolang.jx.module.auth.consts;

import com.laolang.jx.framework.common.consts.BizCode;

public enum AuthBizCode implements BizCode {
    user_login_not_exist("user_login_not_exist", "用户不存在"),
    user_login_locked("user_login_locked", "用户被锁定"),
    user_login_bad_credentials("user_login_bad_credentials", "用户名或密码错误"),
    auth_getuser_failed("auth_getuser_failed", "获取用户信息异常"),
    auth_forbidden("auth_forbidden", "用户无权限操作"),
    ;
    /**
     * 业务状态码.
     */
    private final String code;

    /**
     * 提示信息.
     */
    private final String msg;

    AuthBizCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
