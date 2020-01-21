package com.baranowski.bartosz.exceptions;

public class InvalidFieldException extends RuntimeException {
  public InvalidFieldException(String message) {
    super(message);
  }
}
