package com.presight.ai.consumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
@Node("Author")
public class Author extends BaseEntity {

    private String name;

    @Relationship(type = "AUTHORED", direction = Relationship.Direction.INCOMING)
    private List<Book> books;//= new ArrayList<>();
}
