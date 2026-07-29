package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 해당 클래스가 JPA가 관리하는 엔티티 객체임을 스프링에 알림 
// 스프링 부트 실행 시 @Entity 설정을 기반으로 데이터베이스에 course 테이블을 자동으로 생성
@Entity                 
@Data                   
// 매개변수가 없는 기본 생성자를 자동으로 생성
// JPA 규약상 엔티티 클래스는 반드시 기본 생성자를 가지고 있어야 함
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    // 테이블의 기본키(PK)를 지정
    @Id
    // 기본키의 값 생성 전략을 설정
    // IDENTITY 전략은 ID 값을 자동으로 1씩 증가시키며 채워 주는 방식
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String topic; 
    
    private String description;
}