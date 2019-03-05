package com.web.yueqi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 16:34
 * @Description: user实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;
}
