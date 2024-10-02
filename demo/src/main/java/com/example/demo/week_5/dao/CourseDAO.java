package com.example.demo.week_5.dao;

import com.example.demo.week_5.entity.Course;
import java.util.List;

public interface CourseDAO {
    void save(Course course);
    Course findById(Long id);
    List<Course> findAll();
    void update(Course course);
    void delete(Long id);
}
