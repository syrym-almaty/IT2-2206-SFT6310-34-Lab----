package com.example.demo.week_5.controller;

import com.example.demo.week_5.entity.Course;
import com.example.demo.week_5.entity.Student;
import com.example.demo.week_5.service.CourseService;
import com.example.demo.week_5.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/week5/enrollments")
public class EnrollmentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @PostMapping("/students/{studentId}/courses/{courseId}")
    public String enrollStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentService.getById(studentId).orElse(null);
        Course course = courseService.getById(courseId).orElse(null);

        if (student == null || course == null) {
            return "Student or Course not found";
        }

        student.addCourse(course); // Method now exists
        studentService.save(student);

        return "Student enrolled to course successfully";
    }

    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public String removeStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentService.getById(studentId).orElse(null);
        Course course = courseService.getById(courseId).orElse(null);

        if (student == null || course == null) {
            return "Student or Course not found";
        }

        student.removeCourse(course); // Method now exists
        studentService.save(student);

        return "Student removed from course successfully";
    }
}
