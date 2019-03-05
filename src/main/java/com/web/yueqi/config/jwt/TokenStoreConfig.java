package com.web.yueqi.config.jwt;

import com.web.yueqi.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 10:54
 * @Description: 关于jwt Token存储方式
 */
@Configuration
public class TokenStoreConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 当配置文件中imooc.security.oauth2.storeType = redis 时该内部类的所有配置都会生效
     */
    @Bean
    @ConditionalOnProperty(prefix = "yueqi.security.oauth2", name = "storeType",havingValue = "redis")
    public TokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * 当配置文件中imooc.security.oauth2.storeType = jwt 时该内部类的所有配置都会生效，matchIfMissing = ture 时没有配置时也会生效
     */
    @Configuration
    @ConditionalOnProperty(prefix = "yueqi.security.oauth2", name = "storeType",havingValue = "jwt",matchIfMissing = true)
    public static class JwtTokenConfig{

        @Autowired
        private SecurityProperties securityProperties;

        @Autowired
        private RedisConnectionFactory redisConnectionFactory;

        /**
         * 使用redis缓存jwt Token
         * @return
         */
        @Bean
        public TokenStore jwtTokenStore(){
            return new RedisTokenStore(redisConnectionFactory);
        }

        /**
         * 完成Token 生成中的处理
         * @return
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter(){
            JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
            //获得密钥，设置数字签名
            accessTokenConverter.setSigningKey(securityProperties.getOauth2().getJwtSigningKey());
            return accessTokenConverter;
        }

        @Bean
        @ConditionalOnMissingBean(name="jwtTokenEnhancer")
        public TokenEnhancer jwtTokenEnhancer(){
            return new CustomJwtTokenEnhancer();
        }
    }
}
