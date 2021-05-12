/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author ASUS
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http//To change body of generated methods, choose Tools | Templates.
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/login").permitAll()
                .antMatchers("/catalog/applicant/**/**", "/eventhistory/**").hasRole("ADMIN")
                .antMatchers("/myevent/**").hasRole("USER")
                .antMatchers("/profile").hasRole("USER")
                .antMatchers("/**","logout").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .failureForwardUrl("/login?error")
                .successForwardUrl("/home")
                .permitAll();
    }
    
    
}
