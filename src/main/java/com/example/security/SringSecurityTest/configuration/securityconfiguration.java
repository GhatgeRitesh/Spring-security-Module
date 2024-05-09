package com.example.security.SringSecurityTest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityconfiguration {

    // configure spring security pages which to be public and which not to be
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity
                .authorizeHttpRequests(registry ->{
                 registry.requestMatchers("/home/public")
                    .permitAll();
                 registry.requestMatchers("/home/admin/**").hasRole("ADMIN");
                 registry.requestMatchers("/home/normal/**").hasRole("USER");
                 registry.anyRequest().authenticated();
                 })
                .formLogin(formLogin -> formLogin.permitAll())
                .build();
//                .requestMatchers("/home/public")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
//        return httpSecurity.build();
    }

    // temporary user credential bean
    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails normalUser= User.builder()
                .username("dev")
                .password("$2a$12$nw5GNMmMtQfy0/0TWChkMOLu61ESIS4eB7D4TH8YzZx6P9X9AEgFy")
                .roles("normal")
                .build();
        return new InMemoryUserDetailsManager(normalUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
