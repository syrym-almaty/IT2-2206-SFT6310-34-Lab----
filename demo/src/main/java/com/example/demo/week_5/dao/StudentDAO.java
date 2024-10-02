package com.example.demo.week_5.dao;

import com.example.demo.week_5.entity.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Long id);
    List<Student> findAll();
    void update(Student student);
    void delete(Long id);
}
