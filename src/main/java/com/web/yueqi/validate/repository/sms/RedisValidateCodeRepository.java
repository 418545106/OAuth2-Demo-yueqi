package com.web.yueqi.validate.repository.sms;

import com.web.yueqi.validate.code.ValidateCode;
import com.web.yueqi.validate.code.ValidateCodeType;
import com.web.yueqi.validate.exception.ValidateCodeException;
import com.web.yueqi.validate.repository.ValidateCodeRepository;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:31
 * @Description: 使用redis保存校验码，验证时从redis中取出验证
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
        redisTemplate.opsForValue().set(buildKey(request, type), code, 30, TimeUnit.MINUTES);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType type) {
        Object value = redisTemplate.opsForValue().get(buildKey(request, type));
        if (value == null) {
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType type) {
        redisTemplate.delete(buildKey(request, type));
    }

    /**
     * @param request
     * @param type
     * @return 在请求体中获取请求的手机号，把手机号作为主键
     */
    private String buildKey(ServletWebRequest request, ValidateCodeType type) {
        String mobile = null;
        try {
            mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(),"mobile");

        }catch (Exception e){
            e.printStackTrace();
        }
        if (StringUtils.isBlank(mobile)) {
            throw new ValidateCodeException("请在请求中携带mobile参数");
        }
        String key = "code:" + type.toString().toLowerCase() + ":" + mobile;
        logger.info("redis中的key为：{}",key);
        return key;
    }

}
