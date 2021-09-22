package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@Getter
public abstract class BaseEntity implements AbstractEntity {

    /**
     * 	The only supported generated ID field on classes annotated with @RelationshipProperties is @GeneratedValue with using the default ID generator InternalIdGenerator as shown above. Other generators will lead to a failure during startup..
     */

    @Id
    @GeneratedValue
//    @Setter(AccessLevel.NONE)
    private Long id;

}

