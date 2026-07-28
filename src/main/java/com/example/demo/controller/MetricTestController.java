package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.SimpleCustomMetrics;

@Controller
public class MetricTestController {
    private SimpleCustomMetrics metrics;

    public MetricTestController(SimpleCustomMetrics metrics) {
        this.metrics = metrics;
    }

    @GetMapping("/api/increase")
    @ResponseBody
    public String increaseValue() {
        metrics.increase();
        return "sampleValue 증가됨! 현재값 = " + metrics.getSampleValue();
    }

    @GetMapping("/api/decrease")
    @ResponseBody
    public String decreaseValue() {
        metrics.decrease();
        return "sampleValue 감소됨! 현재값 = " + metrics.getSampleValue();
    }
}
