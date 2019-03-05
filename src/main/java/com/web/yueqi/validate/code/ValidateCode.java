package com.web.yueqi.validate.code;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 14:09
 * @Description: 校验码实体类
 */
@Getter
@Setter
public class ValidateCode implements Serializable {

    private static final long serialVersionUID = -8962056238131608175L;

    /**
     * 校验码号
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    public ValidateCode(String code, Integer expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    /**
     * 校验是否已经过期
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
