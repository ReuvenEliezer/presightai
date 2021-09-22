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
public class Actor {//extends BaseEntity {

    /**
     * 	The only supported generated ID field on classes annotated with @RelationshipProperties is @GeneratedValue with using the default ID generator InternalIdGenerator as shown above. Other generators will lead to a failure during startup..
     */

    @Id
    @GeneratedValue
//    @Setter(AccessLevel.NONE)
    private Long id;

    @TargetNode
    private Person person;

    private List<String> roles = new ArrayList<>();

}
