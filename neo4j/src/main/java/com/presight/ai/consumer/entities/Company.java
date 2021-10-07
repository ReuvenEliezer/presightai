package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
@AllArgsConstructor
@Node("Company")
public class Company extends BaseEntity {

    private String name;

    @Relationship(value = "CARS", direction = Relationship.Direction.OUTGOING)
    private List<Car> cars;
}
