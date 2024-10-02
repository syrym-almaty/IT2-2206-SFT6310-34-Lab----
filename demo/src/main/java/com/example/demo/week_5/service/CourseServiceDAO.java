package com.example.demo.week_5.service;

import com.example.demo.week_5.dao.CourseDAO;
import com.example.demo.week_5.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceDAO {

    @Autowired
    private CourseDAO courseDAO;

    // Create
    public void save(Course course) {
        courseDAO.save(course);
    }

    // Read
    public List<Course> getAll() {
        return courseDAO.findAll();
    }

    public Course getById(Long id) {
        return courseDAO.findById(id);
    }

    // Update
    public void update(Course course) {
        courseDAO.update(course);
    }

    // Delete
    public void deleteById(Long id) {
        courseDAO.delete(id);
    }
}
