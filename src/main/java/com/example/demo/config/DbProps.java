package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Validated
@ConfigurationProperties(prefix = "db")
public record DbProps(
    @NotBlank String url, 
    @NotBlank String username, 
    @NotBlank String password, 
    @Min(1) @Max(10) int poolSize
) {}
