package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseResponse;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
// 생성자를 이용한 의존 주입
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseResponse createCourse(String name, List<String> topics) {
        log.info("topics-size={}", topics.size());

        // topics 리스트를 콤마로 구분된 문자열로 변환
        String topic = String.join(",", topics);
        String desc = String.format("%s님이 관심 있는 분야: %s", name, String.join(", ", topics));
        
        // Course 엔터티 생성
        Course course = new Course();
        course.setName(name);
        course.setTopic(topic);
        course.setDescription(desc);
        
        // H2 DB에 저장
        Course savedCourse = courseRepository.save(course);
        
        // 응답 객체 생성
        CourseResponse response = new CourseResponse();
        response.setName(savedCourse.getName());
        response.setTopics(topics);
        response.setDescription(savedCourse.getDescription());
        return response;
    }
}
