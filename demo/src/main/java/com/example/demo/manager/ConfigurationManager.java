package com.example.demo.manager;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        System.out.println("Loading configuration...");
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void displayConfig() {
        System.out.println("Displaying configuration...");
    }
}
