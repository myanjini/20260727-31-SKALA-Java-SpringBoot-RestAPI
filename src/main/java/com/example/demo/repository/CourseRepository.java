package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;

// JpaRepository<Course, Long> 상속만으로 기본적인 CRUD(Save, FindById, Delete 등) 메서드를 별도 구현 없이 사용 가능
// 첫 번째 인자는 엔티티 클래스 타입(Course), 두 번째 인자는 기본키 타입(Long)
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // 쿼리 메서드: 메서드 이름의 규칙만 맞추면 자동으로 SQL 쿼리를 생성해 주는 기능
    
    // 1. findByName : 이름으로 완벽히 일치하는 코스 조회
    List<Course> findByName(String name);

    // 2. findByTopicContaining : 특정 토픽 문자열이 포함된 코스 조회 (Like 쿼리 실행)
    List<Course> findByTopicContaining(String topic);
}
