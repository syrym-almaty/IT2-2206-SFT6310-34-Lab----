package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<com.example.demo.entity.Role> roles;


    // Implement methods from UserDetails interface
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(() -> role.getName()); // Предполагается, что в Role есть метод getName()
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Настройте по вашим требованиям
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Настройте по вашим требованиям
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Настройте по вашим требованиям
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    // Геттеры и сеттеры для других полей
}
