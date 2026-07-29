package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseResponse;
import com.example.demo.dto.HelloResponse;
import com.example.demo.service.CourseService;
import com.example.demo.service.HelloService;

@RestController
public class HelloController {
    // 의존 객체
    private final HelloService helloService;
    private final CourseService courseService;

    // 생성자를 이용해서 의존 주의
    public HelloController(HelloService helloService, CourseService courseService) {
        this.helloService = helloService;
        this.courseService = courseService;
    }

    // GET 방식으로 /hello?name=매개변수값 형식의 요청을 처리하는 메서드 
    @GetMapping("/hello")
    public HelloResponse hello(@RequestParam(value = "name", defaultValue = "SKALA") String name) {
        return helloService.createMessage(name);
    }

    @PostMapping("/courses/{name}")
    public CourseResponse getClassInfo(@PathVariable("name") String name, @RequestParam List<String> topics) {
        return courseService.createCourse(name, topics);
    }
}
