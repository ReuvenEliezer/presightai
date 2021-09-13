package com.presight.ai.consumer.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@Builder
@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
@AllArgsConstructor
@Node("Phone")
public class Phone extends BaseEntity {

    private String phoneNumber;

    @Relationship(type = "CALLED", direction = Relationship.Direction.OUTGOING)
    private List<Call> calls = new ArrayList<>();

//    @Relationship(type = "PHONE", direction = Relationship.Direction.OUTGOING)
//    private List<Phone> phones = new ArrayList<>();

}
