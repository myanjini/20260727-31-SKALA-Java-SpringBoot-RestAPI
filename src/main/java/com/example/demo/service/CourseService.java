package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseResponse;

@Service
public class CourseService {
    public CourseResponse createCourse(String name, List<String> topics) {
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
