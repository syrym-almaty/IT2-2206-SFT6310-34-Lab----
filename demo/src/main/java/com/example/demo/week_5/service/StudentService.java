package com.example.demo.week_5.service;

import com.example.demo.week_5.entity.Student;
import com.example.demo.week_5.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Read
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    // Update
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    // Delete
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
