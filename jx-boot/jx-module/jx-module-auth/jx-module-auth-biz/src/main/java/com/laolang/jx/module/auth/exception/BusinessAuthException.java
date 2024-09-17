package com.laolang.jx.module.auth.exception;

import com.laolang.jx.framework.common.consts.BizCode;
import com.laolang.jx.framework.common.exception.BusinessException;

public class BusinessAuthException extends BusinessException {
    public BusinessAuthException(String code, String msg) {
        super(code, msg);
    }

    public BusinessAuthException(BizCode bizCode) {
        super(bizCode);
    }
}
