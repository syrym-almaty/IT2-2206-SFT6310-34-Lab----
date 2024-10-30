package com.example.oauthwithgoogle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/login").permitAll() //доступ к корневому маршруту и странице логина
                        .anyRequest().authenticated() // калгандары требуют аутентификации
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/welcome", true) // мув на страницу приветствия после логина

                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login") // URL после логаут
                        .permitAll()
                );

        return http.build(); // фильтр
    }
}
