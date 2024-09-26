package com.laolang.jx.module.system.user.exception;

import com.laolang.jx.framework.common.consts.BizCode;
import com.laolang.jx.framework.common.exception.BusinessException;

public class BusinessSystemUserException extends BusinessException {
    public BusinessSystemUserException(BizCode bizCode) {
        super(bizCode);
    }
}
