package com.web.yueqi.validate.generator;

import com.web.yueqi.validate.code.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:06
 * @Description: 校验码生成类
 */
public interface ValidateCodeGenerator {

    /**
     * 生成校验码
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}
