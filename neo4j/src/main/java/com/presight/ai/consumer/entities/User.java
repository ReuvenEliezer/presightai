//package com.presight.ai.consumer.entities;
//
//import lombok.*;
//import org.springframework.data.neo4j.core.schema.Node;
//import org.springframework.data.neo4j.core.schema.Relationship;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
//@Node("User")
//public class User extends BaseEntity {
//
//    private String name;
//    private String username;
//    private String address;
//    private String email;
//
//    @Relationship(type = "REPORT")
//    private List<Report> reports = new ArrayList<>();
//}
