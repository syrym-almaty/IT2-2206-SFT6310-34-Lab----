package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;  // Предполагается, что у тебя есть своя сущность Role

    // Реализуй методы интерфейса UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
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
        return true;  // Здесь можно добавить свою логику
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Здесь можно добавить свою логику
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Здесь можно добавить свою логику
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
