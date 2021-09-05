//package com.presight.ai.consumer.entities;
//
//import lombok.*;
//import org.neo4j.ogm.annotation.Relationship;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import org.springframework.data.neo4j.core.schema.Node;
//
//
//@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
//@Data
//@Node("Phone")
//public class Phone {
//
//    @Id
//    @GeneratedValue
//    @Setter(AccessLevel.NONE)
//    private Long id;
//
//    private String phoneNumber;
//
//    public Phone(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    @Relationship(type = "RATED",direction = Relationship.INCOMING)
//    private List<Call> calls= new ArrayList<>();
//
//
//
//
//
//}
