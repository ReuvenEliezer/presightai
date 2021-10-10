package com.presight.ai.consumer.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node("Person")
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    @Email
    private String email;

    @Relationship(value = "CARS_OWNER", direction = Relationship.Direction.OUTGOING)
    private List<Car> carsOwner = new ArrayList<>();

    @Relationship(value = "CARS_DRIVES", direction = Relationship.Direction.OUTGOING)
    private List<Car> carsDrives = new ArrayList<>();

    @Relationship(value = "REVIEWED", direction = Relationship.Direction.OUTGOING)
    private List<Movie> reviewed = new ArrayList<>();

    @Relationship(value = "PHONE_OWNER", direction = Relationship.Direction.OUTGOING)
    private List<Phone> phones = new ArrayList<>();

    @Relationship(value = "LOVES", direction = Relationship.Direction.OUTGOING)
    private List<Person> loves = new ArrayList<>();

    //instead of @StartNode
//    //https://stackoverflow.com/questions/67558448/spring-data-neo4j-implement-relationship-entity-with-relationshipproperties-and
//    @Relationship(value = "RATED", direction = Relationship.Direction.OUTGOING)// direction can be OUTGOING (default) or INCOMING
//    private SkillRating  relationshipValue;

}