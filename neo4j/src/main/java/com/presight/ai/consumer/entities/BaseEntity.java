package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@Getter
public abstract class BaseEntity implements AbstractEntity {

    @Id
    @GeneratedValue
//    @Setter(AccessLevel.NONE)
    private Long id;

}

