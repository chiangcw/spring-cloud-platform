package com.chiangcw.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.chiangcw.demo.service.CustomerService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    public CustomerService customerService()
    {
        return new CustomerService();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customerService());
    }

    protected void configure(HttpSecurity http) throws Exception
    {
        logger.debug(
                "Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

        //http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
                .failureUrl("/login?errro").permitAll().and().logout().permitAll();
    }
}
