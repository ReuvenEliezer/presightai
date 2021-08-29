//package com.presight.ai.consumer.config;
//
//
//import com.presight.ai.consumer.entities.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.index.Index;
//import org.springframework.data.mongodb.core.index.IndexInfo;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//@Configuration
//@DependsOn("mongoTemplate")
//public class MongoCollectionsConfig {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @PostConstruct
//    public void initIndexes() {
//        mongoTemplate.indexOps(Person.class)
//                .ensureIndex(new Index().on("phone_list", Sort.Direction.ASC));
//    }
//}