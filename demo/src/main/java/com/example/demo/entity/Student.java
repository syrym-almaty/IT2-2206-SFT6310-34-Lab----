package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name; // Поле для имени
    private String email; // Поле для email

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    // Геттеры и сеттеры
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() { // Геттер для поля name
        return name;
    }

    public void setName(String name) { // Сеттер для поля name
        this.name = name;
    }

    public String getEmail() { // Геттер для поля email
        return email;
    }

    public void setEmail(String email) { // Сеттер для поля email
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
