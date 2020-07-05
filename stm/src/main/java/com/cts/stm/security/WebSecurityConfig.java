package com.cts.stm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.cts.stm.custom.CustomAccessDeniedHandler;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and().authorizeRequests().antMatchers("/add-operations/add_teacher").hasAuthority("ADMIN")
                .and().authorizeRequests().antMatchers("/add-operations/add_student").hasAuthority("ADMIN")
                .and().authorizeRequests().antMatchers("/edit-operations/edit_student").hasAuthority("ADMIN")
                .and().authorizeRequests().antMatchers("/edit-operations/edit_teacher").hasAuthority("ADMIN")
                .and().authorizeRequests().antMatchers("/main/index/actions").hasAuthority("ADMIN")
                .and().authorizeRequests().antMatchers("/main/teachers/actions").hasAuthority("ADMIN")
                .and().authorizeRequests().anyRequest().hasAnyAuthority("ADMIN", "USER")
                .and().formLogin().defaultSuccessUrl("/main/index",true)
                .permitAll()
                .and().logout().logoutSuccessUrl("/login").permitAll()
                .and().exceptionHandling().accessDeniedPage("/access_denied").accessDeniedHandler(accessDeniedHandler())
                .and().csrf().disable();
    }


}
