package com.presight.ai.consumer.entities;


import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node("Movie")
public class Movie extends BaseEntity {

    private String title;

    @Property("tagline")
    private String description;

    @Relationship(value = "ACTED_IN", direction =Relationship.Direction.INCOMING)
    private List<Actor> actors = new ArrayList<>();

//    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
//    private List<Role> actorsAndRoles = new ArrayList<>();
//
//    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
//    private List<Person> directors = new ArrayList<>();

}
