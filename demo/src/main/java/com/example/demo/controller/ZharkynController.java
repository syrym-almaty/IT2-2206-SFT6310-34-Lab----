package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zhako")
public class ZharkynController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get/{name}")
    public Student getStudent(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }
}
