package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseGrade;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class EnrollmentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;



    public void enrollStudentInCourse(UUID studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new com.example.demo.exception.ResourceNotFoundException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new com.example.demo.exception.ResourceNotFoundException("Course not found"));

        if (student.getCourses().size() >= 5) {
            throw new BusinessException("Student cannot enroll in more than 5 courses");
        }

        if (course.getStudents().size() >= 30) {
            throw new BusinessException("Course cannot have more than 30 students");
        }

        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    public Double calculateGPA(UUID studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        List<CourseGrade> grades = student.getCourseGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (CourseGrade grade : grades) {
            int credits = grade.getCourse().getCredit();
            totalPoints += grade.getGrade() * credits;
            totalCredits += credits;
        }

        return 0.0;
    }

}