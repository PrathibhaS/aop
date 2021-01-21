package com.learn.aop.exception;

import org.springframework.validation.Errors;

public class InvalidRequestException extends Exception {
  private static String message = "Invalid entry. Constraints violated";
  private Errors errors;

  public InvalidRequestException() {
    super(message);
  }

  public InvalidRequestException(Errors err) {
    super(message);
    this.errors = err;
  }

  public InvalidRequestException(String message) {
    super(message);
  }
}
