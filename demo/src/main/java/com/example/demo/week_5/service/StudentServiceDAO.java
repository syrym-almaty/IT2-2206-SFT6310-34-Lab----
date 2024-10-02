package com.example.demo.week_5.service;

import com.example.demo.week_5.dao.StudentDAO;
import com.example.demo.week_5.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceDAO {

    @Autowired
    private StudentDAO studentDAO;

    // Create
    public void save(Student student) {
        studentDAO.save(student);
    }

    // Read
    public List<Student> getAll() {
        return studentDAO.findAll();
    }

    public Student getById(Long id) {
        return studentDAO.findById(id);
    }

    // Update
    public void update(Student student) {
        studentDAO.update(student);
    }

    // Delete
    public void deleteById(Long id) {
        studentDAO.delete(id);
    }
}
