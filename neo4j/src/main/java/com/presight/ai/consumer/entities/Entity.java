package com.presight.ai.consumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
@Data
@AllArgsConstructor
@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
@Node("Entity")
public class Entity extends BaseEntity{
    private String name;
    private String address;

    @Relationship(type = "BELONG", direction = Relationship.Direction.INCOMING)
    private BelongRelationship belongRelationship;
}
