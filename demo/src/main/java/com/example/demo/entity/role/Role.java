package com.example.demo.entity.role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

public enum Role {
    ADMIN, STUDENT
}
