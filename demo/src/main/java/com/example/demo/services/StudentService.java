package com.example.demo.services;

import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.GradeRepository;


import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GradeRepository gradeRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudent(UUID id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    // Add other fields as necessary
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }

    public double calculateGPA(UUID studentId) {
        // Находим студента по ID
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));


        // Получаем все оценки студента

        List<Grade> grades = gradeRepository.findByStudent(student);

        // Если у студента нет оценок, возвращаем GPA 0
        if (grades.isEmpty()) {
            return 0.0;
        }

        // Считаем сумму всех оценок
        double totalGrades = 0.0;
        for (Grade grade : grades) {
            totalGrades += grade.getScore(); // Используем getScore() для получения оценки
        }

        // Рассчитываем среднее значение (GPA)
        double gpa = totalGrades / grades.size();

        // Обновляем GPA студента
        student.setGpa(gpa);
        studentRepository.save(student);

        return gpa; // Возвращаем рассчитанный GPA
    }

}
