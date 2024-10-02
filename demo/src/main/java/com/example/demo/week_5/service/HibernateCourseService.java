package com.example.demo.week_5.service;

import com.example.demo.week_5.entity.Course;
import com.example.demo.week_5.pattern.HibernateCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateCourseService {

    @Autowired
    private HibernateCourseRepository hibernateCourseRepository;

    public void save(Course course) {
        hibernateCourseRepository.save(course);
    }

    public List<Course> findByTitle(String title) {
        return hibernateCourseRepository.findByTitle(title);
    }

    // Other methods as needed
}
