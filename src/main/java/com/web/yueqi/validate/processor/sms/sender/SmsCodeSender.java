package com.web.yueqi.validate.processor.sms.sender;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:59
 * @Description: 短信发送接口
 */
public interface SmsCodeSender {

    /**
     * 发送短信
     * @param mobile
     * @param code
     */
    void send(String mobile,String code);
}
