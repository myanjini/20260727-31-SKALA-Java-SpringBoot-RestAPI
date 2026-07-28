package com.example.demo.service;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

@Component
public class SimpleCustomMetrics implements MeterBinder {
    // 임의의 값 (현재 상태를 의미)
    private int sampleValue = 10;

    @Override
    public void bindTo(MeterRegistry registry) {
        Gauge.builder("custom.sample.value", this, SimpleCustomMetrics::getSampleValue)
                .description("샘플 상태값 (예: 현재 처리중인 작업 수)")
                .tag("service", "payment")
                .register(registry);
    }

    // Getter
    public int getSampleValue() {
        return sampleValue;
    }

    // 값 변경 메서드 (테스트용)
    public void increase() {
        sampleValue++;
    }

    // 값 감소
    public void decrease() {
        if (sampleValue > 0)
            sampleValue--;
    }
}
