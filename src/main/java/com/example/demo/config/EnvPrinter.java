package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

// @Component: 스프링이 이 클래스를 빈(Bean)으로 자동 등록
// CommandLineRunner: 스프링 부트 애플리케이션이 완전히 구동된 직후에 run 메서드 내의 코드를 자동으로 실행해 주는 인터페이스
@Component
public class EnvPrinter implements CommandLineRunner {
    private final Environment env;

    // @Value("${app.name}"): 설정 파일에 있는 app.name 값을 읽어와 appName 변수에 주입
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    // 생성자를 이용한 의존 주의
    public EnvPrinter(Environment env) {
        this.env = env;
    }

    @Override
    public void run(String ...args) throws Exception {
        System.out.println("String Boot Environment 실습");

        // 1. Environment 객체를 통한 값 조회
        System.out.println("server.port = " + env.getProperty("server.port"));
        System.out.println("app.mode = " + env.getProperty("app.mode"));

        // 2. @Value로 주입받은 값
        System.out.println("app.name = " + appName);
        System.out.println("app.version = " + appVersion);

        // 3. 활성 프로파일 출력
        String[] acdveProfiles = env.getActiveProfiles();
        if (acdveProfiles.length == 0) {
            System.out.println("activeProfiles = (none)");
        } else {
            System.out.println("activeProfiles = " + String.join(", ", acdveProfiles));
        }
        
        System.out.println("Environment 테스트 완료");
    }
}
