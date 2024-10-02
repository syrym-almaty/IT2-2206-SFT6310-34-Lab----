package com.example.demo.week_5.service;

import com.example.demo.week_5.entity.Student;
import com.example.demo.week_5.pattern.HibernateStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateStudentService {

    @Autowired
    private HibernateStudentRepository hibernateStudentRepository;

    public void save(Student student) {
        hibernateStudentRepository.save(student);
    }

    public List<Student> findByName(String name) {
        return hibernateStudentRepository.findByName(name);
    }

    // Other methods as needed
}
