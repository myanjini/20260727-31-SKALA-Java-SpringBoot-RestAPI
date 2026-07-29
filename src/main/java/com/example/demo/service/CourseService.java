package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseService {
    public CourseResponse createCourse(String name, List<String> topics) {
        log.trace("createCourse 메서드 호출");
        log.debug("createCourse 메서드 호출");
        log.info("createCourse 메서드 호출");
        log.warn("createCourse 메서드 호출");
        log.error("createCourse 메서드 호출");

        CourseResponse response = new CourseResponse();
        response.setName(name);
        response.setTopics(topics);
        String desc = String.format(
                "%s님이 관심 있는 교과과정: %s",
                name, String.join(", ", topics));
        response.setDescription(desc);
        return response;
    }
}
