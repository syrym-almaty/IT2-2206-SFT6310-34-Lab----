package com.example.demo.exceptions;


public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}

