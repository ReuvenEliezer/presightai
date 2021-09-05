package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class SkillRating {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long graphId;

    private Integer score;
    private LocalDate measurementDate;

    @TargetNode //instead @EndNode
    private Skill skill;
}
