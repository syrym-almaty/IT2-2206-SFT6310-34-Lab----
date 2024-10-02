package com.example.demo.week_5.service;

import com.example.demo.week_5.entity.Course;
import com.example.demo.week_5.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    // Read
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> getById(Long id) {
        return courseRepository.findById(id);
    }

    // Update
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    // Delete
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
