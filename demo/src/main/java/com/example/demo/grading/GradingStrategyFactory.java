package com.example.demo.grading;

public class GradingStrategyFactory {
    public static GradingStrategy getStrategy(String type) {
        if (type.equalsIgnoreCase("letter")) {
            return new LetterGradingStrategy();
        } else if (type.equalsIgnoreCase("percentage")) {
            return new PercentageGradingStrategy();
        }
        return null;
    }
}
