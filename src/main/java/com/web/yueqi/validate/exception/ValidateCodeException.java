package com.web.yueqi.validate.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:33
 * @Description: 校验码异常
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
