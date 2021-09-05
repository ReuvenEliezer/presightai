package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

@Data
//@Builder
@NoArgsConstructor
//@AllArgsConstructor
@Node("Person")
public class Person extends BaseEntity {

    private String name;

    private Integer born;

    public Person(Integer born, String name) {
        this.born = born;
        this.name = name;
    }


//    private String firstName;
//    private String lastName;
//    private LocalDate birthday;
//    private String email;
//
//
//    //instead of @StartNode
//    //https://stackoverflow.com/questions/67558448/spring-data-neo4j-implement-relationship-entity-with-relationshipproperties-and
//    @Relationship(value = "RATED", direction = Relationship.Direction.OUTGOING)// direction can be OUTGOING (default) or INCOMING
//    private SkillRating  relationshipValue;
}