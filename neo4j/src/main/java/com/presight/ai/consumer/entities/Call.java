//package com.presight.ai.consumer.entities;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.*;
//import java.util.stream.Collectors;
//
//import lombok.*;
//import org.springframework.data.neo4j.core.schema.Id;
//import org.springframework.data.neo4j.core.schema.Node;
//import org.springframework.data.neo4j.core.schema.Property;
//import org.springframework.data.neo4j.core.schema.Relationship;
//import org.springframework.data.neo4j.core.schema.GeneratedValue;
//
//@Data
//@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
//public class Call {
//
//    @Id
//    @GeneratedValue
//    @Setter(AccessLevel.NONE)
//    private Long id;
//
//
//    private String fromPhoneNum;
//    private String toPhoneNum;
//    private LocalDateTime calTime;
//    private Duration callDuration;
//    private RegineTypeEnum regineFrom;
//    private RegineTypeEnum regineTo;
////    private String provider; // TODO?
//
//    public Call(String fromPhoneNum, String toPhoneNum, LocalDateTime calTime, Duration callDuration, RegineTypeEnum regineFrom, RegineTypeEnum regineTo){
//        this.fromPhoneNum = fromPhoneNum;
//        this.toPhoneNum = toPhoneNum;
//        this.calTime = calTime;
//        this.callDuration = callDuration;
//        this.regineFrom = regineFrom;
//        this.regineTo = regineTo;
//    }
//
////    @Relationship(type = "OUTCOMINGCALLS", direction = Relationship.Direction.OUTGOING)
////    public List<Phone> outComingCalls = new ArrayList<>();
////
////    public void addPhoneDestination(Phone phone) {
////        outComingCalls.add(phone);
////    }
//
//
//}
//
//
