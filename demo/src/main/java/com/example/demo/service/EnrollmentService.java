package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EnrollmentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // Конструкторное внедрение зависимостей
    public EnrollmentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Метод для зачисления студента на курс
    public void enrollStudentInCourse(UUID studentId, UUID courseId) {
        // Найти студента по ID или выбросить исключение, если не найден
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        // Найти курс по ID или выбросить исключение, если не найден
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        // Проверить, что студент не может быть зачислен на более чем 5 курсов
        if (student.getCourses().size() >= 5) {
            throw new BusinessException("Student cannot enroll in more than 5 courses");
        }

        // Проверить, что курс не может содержать более чем 30 студентов
        if (course.getStudents().size() >= 30) {
            throw new BusinessException("Course cannot have more than 30 students");
        }

        // Добавить курс студенту и студента курсу
        student.getCourses().add(course);
        course.getStudents().add(student);

        // Сохранить обновлённые данные студента и курса
        studentRepository.save(student);
        courseRepository.save(course);
    }
}
