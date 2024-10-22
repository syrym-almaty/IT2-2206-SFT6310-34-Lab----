package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Обновлённый способ отключения CSRF защиты
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")  // Ограничение доступа для администраторов
                        .requestMatchers("/api/student/**").hasRole("STUDENT")  // Ограничение доступа для студентов
                        .anyRequest().authenticated()  // Все остальные запросы требуют аутентификации
                )
                .formLogin(withDefaults())  // Включение формы для логина (с современным синтаксисом)
                .httpBasic(withDefaults());  // Включение HTTP Basic аутентификации

        return http.build();
    }

    // Пример создания пользователей в памяти
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("adminpassword"))
                .roles("ADMIN")
                .build();

        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder().encode("studentpassword"))
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(admin, student);
    }

    // Использование BCrypt для шифрования паролей
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
