package io.ao9.flow.api.zuulapigateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment env;

    @Autowired
    public WebSecurity(Environment env) {
        this.env = env;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/actuator/info").permitAll()
                .antMatchers(HttpMethod.POST, env.getProperty("user-api.registeration.url.path")).permitAll()
                .antMatchers(HttpMethod.POST, env.getProperty("user-api.login.url.path")).permitAll()
                .anyRequest().authenticated()
            .and()
                .addFilter(new AuthenticationFilter(authenticationManager(), env));

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.headers().frameOptions().disable();
        http.csrf().disable();
    }

}