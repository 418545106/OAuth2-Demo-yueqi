package com.web.yueqi.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:15
 * @Description: 验证码的配置类
 */
@Getter
@Setter
public class ValidateCodeProperties {

    /**
     * 短信验证码的具体配置类
     */
    private SmsCodeProperties sms = new SmsCodeProperties();

}
