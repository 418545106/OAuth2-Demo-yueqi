package com.web.yueqi.config.oauth2;

import com.web.yueqi.config.security.CustomAuthenticationFailureHandler;
import com.web.yueqi.config.security.CustomAuthenticationSuccessHandler;
import com.web.yueqi.properties.SecurityPath;
import com.web.yueqi.validate.config.SmsCodeAuthenticationSecurityConfig;
import com.web.yueqi.validate.config.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @auther: zpd
 * @Date: 2019/3/4 0004 13:28
 * @Description: 定义OAuth2资源服务器
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;

    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    /**
     * 配置关于验证码验证过滤器
     */
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    /**
     * 配置spring security 路由
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage(SecurityPath.DEFAULT_UNAUTHENTICATED_URL)
                .loginProcessingUrl(SecurityPath.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(successHandler)
                .failureHandler(failureHandler);

        http.apply(validateCodeSecurityConfig)
                    .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                    .and()
                .csrf()
                .disable()
                .cors()
                .disable();

        http.authorizeRequests()
                .antMatchers(SecurityPath.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        SecurityPath.DEFAULT_UNAUTHENTICATED_URL,
                        SecurityPath.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*","/session/invalid","/oauth/**")
                .permitAll()
                .anyRequest()
                .authenticated();

    }
}
