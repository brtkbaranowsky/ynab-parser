package com.baranowski.bartosz.exceptions;

public class NoCsvFileException extends RuntimeException {
    public NoCsvFileException(String message) {
        super(message);
    }
}
