package com.web.yueqi.config.jwt;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 11:00
 * @Description: 实现向jwt Token中存放自定义信息
 */
public class CustomJwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        //要向token中存放的信息
        Map<String,Object> info = new HashMap<>();
        info.put("company","uuz");
        //添加附加信息
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
