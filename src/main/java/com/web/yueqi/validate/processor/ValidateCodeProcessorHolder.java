package com.web.yueqi.validate.processor;

import com.web.yueqi.validate.code.ValidateCodeType;
import com.web.yueqi.validate.exception.ValidateCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @auther: zpd
 * @Date: 2019/2/19 0019 09:58
 * @Description: 验证码处理器的控制器，控制本次验证码验证改用哪种处理器
 */
@Component
public class ValidateCodeProcessorHolder {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    /**
     * @param type
     * @return
     */
    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    /**
     * 根据不同的校验类型 查找不同的校验码处理器
     * @param type
     * @return
     */
    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + "CodeProcessor";
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            try {
                throw new ValidateCodeException("验证码处理器" + name + "不存在");
            } catch (ValidateCodeException e) {
                e.printStackTrace();
            }
        }
        return processor;
    }
}
