package com.example.demo.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice: 애플리케이션 전체(모든 컨트롤러)에서 발생하는 예외를 이 클래스가 가로채서 처리
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 클라이언트가 보낸 요청 데이터의 유효성 검증(@Valid)에 실패했을 때 스프링이 던지는 MethodArgumentNotValidException을 잡아 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValid(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest()
                .body(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    // 데이터베이스나 컬렉션 등에서 요청한 데이터를 찾지 못했을 때 발생하는 NoSuchElementException을 잡아 처리
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());                
    }
}
