package com.example.demo.dto;

import lombok.Data;

@Data
public class HelloResponse {
    private String message;

    // Lombok을 사용하지 않는 경우
    // public HelloResponse() {
    // }

    // public HelloResponse(String message) {
    //     this.message = message;
    // }

    // public String getMessage() {
    //     return message;
    // }

    // public void setMessage(String message) {
    //     this.message = message;
    // }

    // @Override
    // public String toString() {
    //     return "HelloResponse{" + "message='" + message + '\'' + '}';
    // }
}
