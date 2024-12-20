package com.seemee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SeemeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeemeeApplication.class, args);
    }
}