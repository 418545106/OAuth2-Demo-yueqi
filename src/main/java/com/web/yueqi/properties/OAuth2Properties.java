package com.web.yueqi.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 10:41
 * @Description: 关于OAuth2的配置项
 */
@Getter
@Setter
public class OAuth2Properties {

    /**
     * 数字签名
     */
    private String jwtSigningKey = "yueqii";

    /**
     * 客户端配置
     */
    private OAuth2ClientProperties[] clients = {};


}
