package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class CourseResponse {
    private String name;
    private List<String> topics;
    private String description;
}
