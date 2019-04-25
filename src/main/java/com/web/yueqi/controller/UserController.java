package com.web.yueqi.controller;

import com.web.yueqi.domain.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 16:33
 * @Description: user controller
 */
@RestController
public class UserController {

    /**
     * 获取所有信息
     *
     * @return
     */
    @GetMapping("/user")
    public List<UserInfo> queryAll() {
        UserInfo u1 = new UserInfo(1, "uuz", 17);
        UserInfo u2 = new UserInfo(1, "uuz", 17);
        UserInfo u3 = new UserInfo(1, "uuz", 17);
        List<UserInfo> us = new ArrayList<>();
        us.add(u1);
        us.add(u2);
        us.add(u3);
        return us;
    }
}
