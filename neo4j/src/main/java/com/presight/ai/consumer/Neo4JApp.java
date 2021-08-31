package com.presight.ai.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {
        "com.presight.ai.consumer.config",
        "com.presight.ai.consumer.repositories",
        "com.presight.ai.consumer.services",
})
public class Neo4JApp {
    public static void main(String[] args) {
        SpringApplication.run(Neo4JApp.class, args);
    }
}

