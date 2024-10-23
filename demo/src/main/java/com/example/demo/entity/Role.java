package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    private Long id; // Или другой уникальный идентификатор

    private String name; // Название роли

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
