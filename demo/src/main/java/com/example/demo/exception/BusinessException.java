package com.example.demo.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);  // Передаем сообщение в конструктор родителя (RuntimeException)
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);  // Передаем сообщение и причину исключения
    }
}
