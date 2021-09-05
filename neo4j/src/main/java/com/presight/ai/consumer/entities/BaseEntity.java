package com.presight.ai.consumer.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;


@Data
public abstract class BaseEntity implements AbstractEntity {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

}
