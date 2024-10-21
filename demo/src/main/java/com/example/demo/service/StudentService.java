package com.example.demo.service;

import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.exeption.ResourceNotFoundException;
import com.example.demo.repository.GradeRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    public StudentService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }
    public Student updateStudent(UUID id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }
    public double calculateGPA(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        if (grades.isEmpty()) return 0.0;

        double totalScore = grades.stream()
                .mapToDouble(Grade::getScore)
                .sum();
        return totalScore / grades.size();
    }
}
