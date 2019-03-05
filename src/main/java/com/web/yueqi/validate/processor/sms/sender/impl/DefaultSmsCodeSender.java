package com.web.yueqi.validate.processor.sms.sender.impl;

import com.web.yueqi.validate.processor.sms.sender.SmsCodeSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 15:00
 * @Description: 默认的短信发送逻辑
 */
@Component
public class DefaultSmsCodeSender implements SmsCodeSender {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String mobile, String code) {
        logger.info("向手机{}发送短信验证码{}", mobile,code);
    }
}
