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

    // Конструктор по умолчанию для JPA
    public Role() {}

    // Конструктор с параметром
    public Role(RoleType name) {
        this.name = name;
    }

    // Геттер для поля name
    public RoleType getName() {
        return name;
    }

    // Сеттер для поля name
    public void setName(RoleType name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name.name();
    }
}
