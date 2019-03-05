package com.web.yueqi.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @auther: zpd
 * @Date: 2019/1/22 0022 11:08
 * @Description: json 简单返回类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResponse {

    /**
     * 返回内容
     */
    private Object content;

}
