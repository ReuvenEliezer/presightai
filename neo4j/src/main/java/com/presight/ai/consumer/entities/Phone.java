package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
@Data
@Node("Phone")
public class Phone {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String phoneNumber;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Relationship(type = "RATED",direction = Relationship.Direction.INCOMING)
    private List<Call> calls= new ArrayList<>();





}
