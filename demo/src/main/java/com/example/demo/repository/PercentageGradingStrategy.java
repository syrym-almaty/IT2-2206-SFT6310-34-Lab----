package com.example.demo.repository;

public class PercentageGradingStrategy implements GradingStrategy {

    @Override
    public Double calculateGrade(Double score) {
        // Предположим, что score содержит процентный балл
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }

        // Пример: Преобразование процентного значения в оценку
        if (score >= 90) {
            return 4.0;  // A
        } else if (score >= 80) {
            return 3.0;  // B
        } else if (score >= 70) {
            return 2.0;  // C
        } else if (score >= 60) {
            return 1.0;  // D
        } else {
            return 0.0;  // F
        }
    }
}
