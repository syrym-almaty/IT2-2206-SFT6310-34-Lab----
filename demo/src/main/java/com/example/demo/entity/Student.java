package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.Column;
=======
>>>>>>> 73c5406cba414e1fe7e17626a8cbd4c6e1706816
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
<<<<<<< HEAD
    @Column(columnDefinition = "uuid")
=======
>>>>>>> 73c5406cba414e1fe7e17626a8cbd4c6e1706816
    private UUID id;

    private String name;
    private String email;

    // Constructors
    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
	public String getEmail() {
=======
    public String getEmail() {
>>>>>>> 73c5406cba414e1fe7e17626a8cbd4c6e1706816
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
