package com.example.demo.service;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("service", "Payment API")
                .withDetail("maintainer", "ky.in@example.com")
                .withDetail("uptime", System.currentTimeMillis());
    }
}