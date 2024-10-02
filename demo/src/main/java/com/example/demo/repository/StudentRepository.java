package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
=======

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
>>>>>>> 73c5406cba414e1fe7e17626a8cbd4c6e1706816
}
