package com.web.yueqi.validate.processor.sms;

import com.web.yueqi.validate.code.ValidateCode;
import com.web.yueqi.validate.processor.AbstractVaildateCodeProcessor;
import com.web.yueqi.validate.processor.sms.sender.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:57
 * @Description: 短信验证码处理器
 */
@Component
public class SmsCodeProcessor extends AbstractVaildateCodeProcessor<ValidateCode> {

    /**
     * 短信验证码发送器
     */
    @Autowired
    private SmsCodeSender defaultSmsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(),"mobile");
        defaultSmsCodeSender.send(mobile,validateCode.getCode());
    }
}
