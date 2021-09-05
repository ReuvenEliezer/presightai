//package com.presight.ai.consumer.entities;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.neo4j.ogm.annotation.GeneratedValue;
//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
//@Data
//@NodeEntity("User")
//public class User {
//
//    @Id
//    @GeneratedValue
//    @Setter(AccessLevel.NONE)
//    private Long id;
//
//    private String name;
//    private Double age;
//
//
//    @Relationship(type = "RATED",direction = Relationship.INCOMING)
//    private List<Movie> movies= new ArrayList<>();
//
//}
