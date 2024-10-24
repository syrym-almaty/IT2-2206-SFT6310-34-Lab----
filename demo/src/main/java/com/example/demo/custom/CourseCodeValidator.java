package com.example.demo.custom;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



class CourseCodeValidator implements ConstraintValidator<ValidCourseCode, String> {
    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        // Реализуйте логику валидации
        return code != null && code.matches("^[A-Z]{4}\\d{4}$");
    }
}
