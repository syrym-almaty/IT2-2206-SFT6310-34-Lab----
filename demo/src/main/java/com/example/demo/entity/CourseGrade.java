package com.example.demo.entity;


import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "course_grades")
public class CourseGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private double grade;  // Оценка за курс

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Конструкторы, геттеры и сеттеры

    public CourseGrade() {
    }

    public CourseGrade(Course course, double grade, Student student) {
        this.courseName = course.getName();
        this.grade = grade;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getCourseId() {
        return course.getId();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public List<Grade> convertCourseGradesToGrades(List<CourseGrade> courseGrades) {
        return courseGrades.stream().map(courseGrade -> {
            Grade grade = new Grade();
            grade.setId(new GradeId(courseGrade.getStudent().getId(), courseGrade.getCourseId())); // Установка составного ключа
            grade.setScore(courseGrade.getGrade());
            grade.setStudent(courseGrade.getStudent());
            grade.setCourse(courseGrade.getCourse());
            return grade;
        }).collect(Collectors.toList());
    }

}
