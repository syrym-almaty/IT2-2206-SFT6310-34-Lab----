package com.example.demo.week_5.controller;

import com.example.demo.week_5.entity.Student;
import com.example.demo.week_5.service.StudentServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/week5dao/students")
public class StudentControllerDAO {

    @Autowired
    private StudentServiceDAO studentServiceDAO;

    @PostMapping
    public void create(@RequestBody Student student) {
        studentServiceDAO.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentServiceDAO.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentServiceDAO.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id); // Now this method exists
        studentServiceDAO.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentServiceDAO.deleteById(id);
    }
}
