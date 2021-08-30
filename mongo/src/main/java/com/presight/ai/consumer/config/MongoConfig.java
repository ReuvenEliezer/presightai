package com.presight.ai.consumer.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import java.io.IOException;

//@Data
//@Configuration
//@ConfigurationProperties(prefix = "mongo") //https://www.baeldung.com/configuration-properties-in-spring-boot
//public class MongoConfig extends AbstractMongoClientConfiguration {
//
//    private String url;
//    private String tableName;
//
//    @Value("spring.data.mongodb.auto-index-creation")
//    private Boolean isAutoCreation;
//
//
//    @Bean
//    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString(url);
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoClient(), getDatabaseName());
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return tableName;
//    }
//
//    @Override
//    public MongoClient mongoClient() {
////        return createMongoClient();
//        ConnectionString connectionString = new ConnectionString(url);
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Override
//    protected boolean autoIndexCreation() {
//        return true; //TODO set from app.prop
//    }
//}