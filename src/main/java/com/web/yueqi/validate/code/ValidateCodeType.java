package com.web.yueqi.validate.code;

import com.web.yueqi.properties.SecurityPath;

/**
 * @auther: zpd
 * @Date: 2019/2/19 0019 09:17
 * @Description: 校验码类型
 */
public enum ValidateCodeType {
    /**
     * 图形验证码
     */
    IMAGE{
        @Override
        public String getParamNameOnValidate() {
            return SecurityPath.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    },
    /**
     * 短信验证码
     */
    SMS{
        @Override
        public String getParamNameOnValidate() {
            return SecurityPath.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    };

    public abstract String getParamNameOnValidate();
}
