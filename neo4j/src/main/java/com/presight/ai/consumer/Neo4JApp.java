package com.presight.ai.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
        "com.presight.ai.config",
        "com.presight.ai.repositories",
        "com.presight.ai.services",
})
public class Neo4JApp {
    public static void main(String[] args) {
        SpringApplication.run(Neo4JApp.class, args);
    }
}

