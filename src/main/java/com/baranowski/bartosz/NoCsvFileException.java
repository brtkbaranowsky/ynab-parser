package com.baranowski.bartosz;

public class NoCsvFileException extends RuntimeException {
    public NoCsvFileException(String message) {
        super(message);
    }
}
