//package com.presight.ai.consumer.entities;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
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
//@Node("Report")
//public class Report extends BaseEntity {
//
//    private String title;
//    private String description;
//    private String date;
//
//    @Relationship(type = "REPORT", direction = Relationship.Direction.INCOMING)
//    private ReportRelationShip reportRelationShip;
//
//    @Relationship(type = "BELONG")
//    private Entity entity;
//}
