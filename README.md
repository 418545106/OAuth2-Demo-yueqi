# OAuth2-Demo-yueqi
This is Demo of Spring security OAuth2

本项目为在学习完spring security 之后，利用OAuth2 搭建出的一个项目，内部代码为学习之后的整合。

本项目集成OAuth2的认证服务器以及资源服务器。

登陆认证<br>
1.账号密码方式目前使用官方接口 /oauth/token <br>
2.短信登陆方式 先获取短信验证码 /code/sms?mobile=137xxxxxxxxx 之后通过 /authentication/mobile
提交手机号和验证码
[![996.icu](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu)
