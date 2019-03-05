package com.web.yueqi.validate.generator.sms;

import com.web.yueqi.properties.SecurityProperties;
import com.web.yueqi.validate.code.ValidateCode;
import com.web.yueqi.validate.generator.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:12
 * @Description: 短信验证码生成器
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 生成短信验证码
     * @param request
     * @return
     */
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        //获取配置中设置的短信验证码长度
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        //获取配置中设置的短信验证码时长
        return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
    }
}
