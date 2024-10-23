package com.example.demo.factory;

import com.example.demo.strategy.GradingStrategy;
import com.example.demo.strategy.LetterGradingStrategy;
import com.example.demo.strategy.PercentageGradingStrategy;

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
