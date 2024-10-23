package com.example.demo.entity;

import com.example.demo.enums.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @Enumerated(EnumType.STRING)
    private RoleType name;

    @Override
    public String getAuthority() {
        return name.name();
    }
}
