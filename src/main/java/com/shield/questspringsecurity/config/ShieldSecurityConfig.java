package com.shield.questspringsecurity.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ShieldSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/secret-bases/**").hasRole("DIRECTOR")
                .antMatchers("/avengers/assemble/**").hasRole("HERO")
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("user").password("password").roles("");  bis Spring Security 4 möglich

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("");


        auth.inMemoryAuthentication()
                .withUser("Steve Guy")
                .password(encoder.encode("hero1"))
                .roles("HERO")
                .and()
                .withUser("Tony Stark")
                .password(encoder.encode("hero2"))
                .roles("HERO")
                .and()
                .withUser("Nick Fury")
                .password(encoder.encode("12345678"))
                .roles("DIRECTOR");
    }
}