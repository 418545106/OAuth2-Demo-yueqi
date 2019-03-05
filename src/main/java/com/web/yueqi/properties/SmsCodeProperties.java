package com.web.yueqi.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:16
 * @Description: 短信验证码配置类
 */
@Getter
@Setter
public class SmsCodeProperties {

    /**
     * 短信验证码长度
     */
    private Integer length = 6;

    /**
     * 短信验证码有效时长
     */
    private Integer expireIn = 60;

    /**
     * 需要使用到短信验证码的url
     */
    private String url;
}
