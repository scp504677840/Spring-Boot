package com.sl;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/", "/index").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3")
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and();
        //.loginPage("/userlogin")
        //.failureForwardUrl("/error");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("tom").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1")
                .and()
                .withUser("jack").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2")
                .and()
                .withUser("cher").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP3");
    }

}
