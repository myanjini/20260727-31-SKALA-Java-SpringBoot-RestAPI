package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HelloResponse;

@RestController
public class P196HelloController {
    @GetMapping("/hello-p196")
    public HelloResponse hello() {
        HelloResponse response = new HelloResponse();
        response.setMessage("SKALA에 오신 것을 환영합니다.");
        return response;
    }
}
