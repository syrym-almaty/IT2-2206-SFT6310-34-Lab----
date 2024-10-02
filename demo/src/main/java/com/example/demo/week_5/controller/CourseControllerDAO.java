package com.example.demo.week_5.controller;

import com.example.demo.week_5.entity.Course;
import com.example.demo.week_5.service.CourseServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/week5dao/courses")
public class CourseControllerDAO {

    @Autowired
    private CourseServiceDAO courseServiceDAO;

    @PostMapping
    public void create(@RequestBody Course course) {
        courseServiceDAO.save(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseServiceDAO.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return courseServiceDAO.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id); // Now this method exists
        courseServiceDAO.update(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseServiceDAO.deleteById(id);
    }
}
