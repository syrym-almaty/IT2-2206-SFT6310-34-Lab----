package com.example.demo.strategies;

import com.example.demo.repository.GradingStrategy;

public class PercentageGradingStrategy implements GradingStrategy {
    @Override
    public Double calculateGrade(Double score) {
        // Логика для преобразования числового значения в оценку
        return score; // Здесь можно вернуть сам процент или преобразовать его в другую оценку
    }

}
