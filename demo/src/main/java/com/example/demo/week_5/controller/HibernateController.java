package com.example.demo.week_5.controller;

import com.example.demo.week_5.entity.Student;
import com.example.demo.week_5.service.HibernateStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/week5hibernate/students")
public class HibernateController {

    @Autowired
    private HibernateStudentService hibernateStudentService;

    @PostMapping
    public void create(@RequestBody Student student) {
        hibernateStudentService.save(student);
    }

    @GetMapping("/name/{name}")
    public List<Student> getByName(@PathVariable String name) {
        return hibernateStudentService.findByName(name);
    }

    // Other endpoints as needed
}
