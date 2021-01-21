package com.learn.aop.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMessage {
  private HttpStatus code;
  private String message;
  private List<String> errors;

  public ErrorMessage(HttpStatus statusCode, String message) {
    this.code = statusCode;
    this.message = message;
  }
}
