package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
@AllArgsConstructor
@Node("Car")
public class Car extends BaseEntity {

    private String name;
    private String model;
    private ColorEnum color;

    @Relationship(value = "OWNER_BY",direction = Relationship.Direction.OUTGOING)
    private List<Person> ownerBy = new ArrayList<>();

    @Relationship(value = "MANUFACTURER", direction = Relationship.Direction.OUTGOING)
    private Company company;

}
