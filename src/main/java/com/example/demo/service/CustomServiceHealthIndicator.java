package com.example.demo.service;

import java.util.Random;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomServiceHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // (1) 간단한 체크 로직: 임의로 true/false 지정 가능
        boolean serviceRunning = checkMyServiceStatus();
        if (serviceRunning) {
            return Health.up()
                    .withDetail("service", "running")
                    .withDetail("description", "Custom service is healthy")
                    .build();
        } else {
            return Health.down()
                    .withDetail("service", "stopped")
                    .withDetail("description", "Custom service check failed")
                    .build();
        }
    }

    // 서비스 상태를 체크해서 정상 여부(true/false)를 반환
    // ex) DB 연결, 외부 API 호출, 파일 존재 여부 등
    private boolean checkMyServiceStatus() {
        // 여기에서는 랜덤으로 정상 여부를 반환
        Random random = new Random();
        return random.nextBoolean();
    }
}
