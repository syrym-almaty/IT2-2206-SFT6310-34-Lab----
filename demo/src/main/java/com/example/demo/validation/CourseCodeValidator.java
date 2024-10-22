package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Валидатор для проверки правильности кода курса
public class CourseCodeValidator implements ConstraintValidator<ValidCourseCode, String> {

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        return code != null && code.matches("^[A-Z]{4}\\d{4}$"); // Пример кода курса: ABCD1234
    }
}
