package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long>  {
    List<Grade> findByStudent(Student student);
    List<Grade> findByCourse(Course course);
}
