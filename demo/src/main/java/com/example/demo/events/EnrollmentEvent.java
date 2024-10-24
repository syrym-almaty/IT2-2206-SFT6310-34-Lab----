package com.example.demo.events;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;


public class EnrollmentEvent extends ApplicationEvent {
    private final Student student;
    private final Course course;

    public EnrollmentEvent(Object source, Student student, Course course) {
        super(source);
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}


