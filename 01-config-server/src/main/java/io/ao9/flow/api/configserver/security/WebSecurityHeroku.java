package io.ao9.flow.api.configserver.security;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Profile("heroku")
public class WebSecurityHeroku extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {        
        http.authorizeRequests().anyRequest().authenticated();
        http.httpBasic();
        http.csrf().disable();
    }
    
}