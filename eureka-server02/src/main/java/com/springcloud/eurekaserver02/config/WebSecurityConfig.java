package com.springcloud.eurekaserver02.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @description 
 * @author Guoqi
 * @date 2022/03/18 10:48
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);//为了访问eureka和actuator时作安全控制
        httpSecurity.csrf().ignoringAntMatchers("/eureka/**"); //忽略/eureka/的请求
    }
}
