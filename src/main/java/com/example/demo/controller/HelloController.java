package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseResponse;
import com.example.demo.dto.HelloRequest;
import com.example.demo.dto.HelloResponse;
import com.example.demo.service.CourseService;
import com.example.demo.service.HelloService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {
    // 의존 객체
    private final HelloService helloService;
    private final CourseService courseService;

    // 생성자를 이용해서 의존 주의
    public HelloController(HelloService helloService, CourseService courseService) {
        log.trace("HelloController 생성자 호출");
        log.debug("HelloController 생성자 호출");
        log.info("HelloController 생성자 호출");
        log.warn("HelloController 생성자 호출");
        log.error("HelloController 생성자 호출");

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
        log.trace("POST 방식으로 /courses/{name} 엔드포인트 호출");
        log.debug("POST 방식으로 /courses/{name} 엔드포인트 호출");
        log.info("POST 방식으로 /courses/{name} 엔드포인트 호출");
        log.warn("POST 방식으로 /courses/{name} 엔드포인트 호출");
        log.error("POST 방식으로 /courses/{name} 엔드포인트 호출");

        return courseService.createCourse(name, topics);
    }

    // 클라이언트로부터 전달받은 JSON 데이터를 객체로 변환하고, 유효성 검증을 거친 뒤 비즈니스 로직을 처리하여 응답
    // @RequestBody: HTTP 요청의 본문(Body)에 담겨 오는 JSON 데이터를 HelloRequest 자바 객체로 자동 변환(역직렬화)
    // @Valid: HelloRequest 객체 내부의 필드들에 설정된 유효성 검증 어노테이션(예: @NotNull, @Size 등)을 바탕으로, 
    //         입력값이 올바른 형식인지 검사(Validation). 조건에 맞지 않으면 예외를 발생
    @PostMapping("/hello")
    public HelloResponse postHello(@Valid @RequestBody HelloRequest body) {
        log.info("/hello: POST {}", body.getName());
        return helloService.createMessage(body.getName());
    }

    // 전역 예외 처리 테스트를 위한 메서드 추가
    @GetMapping("/test-notfound")
    public String testNotFound() {
        throw new NoSuchElementException("요청하신 데이터를 찾을 수 없습니다.");
    }
    
}
