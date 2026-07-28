package com.example.demo.config;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.unit.DataSize;

@ConfigurationProperties(prefix = "app")
public record AppProps(
    String name, 
    Cors cors,
    Map<String, String> metadata,
    List<String> admins,
    Duration timeout, 
    DataSize maxUpload, 
    Mode mode
) {
    public record Cors(List<String> allowedOrigins) {
    }
    public enum Mode {BASIC, PRO, ENTERPRISE }
}
