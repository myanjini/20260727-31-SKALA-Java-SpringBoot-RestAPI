package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    // 생성자 : 객체가 생성될 때 가장 먼저 자동으로 호출되는 메서드
    public DevConfig() {
        System.out.println("DevConfig");
    }
}
