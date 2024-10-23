package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<ValidCourseCode, String> {

    @Override
    public void initialize(ValidCourseCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        return code != null && code.matches("^[A-Z]{4}\\d{4}$");
    }
}
