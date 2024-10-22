package com.example.demo.validation;

import jakarta.validation.Constraint; // Проверь, что импорт правильный
import jakarta.validation.Payload;    // Проверь, что импорт правильный
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCourseCode {
    String message() default "Invalid course code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
