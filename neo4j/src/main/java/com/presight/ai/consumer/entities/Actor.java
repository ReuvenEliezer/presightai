package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Listing 42. "Standard" movie graph domain model
 * https://docs.spring.io/spring-data/neo4j/docs/current/reference/html/#reference
 * https://docs.spring.io/spring-data/neo4j/docs/current/reference/html/#sdn.testing
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class Actor extends BaseEntity {

    @TargetNode
    private Person person;

    private List<String> roles = new ArrayList<>();

}
