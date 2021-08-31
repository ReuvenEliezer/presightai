package com.presight.ai.consumer.entities;

import java.util.*;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
@Data
@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
public class Call {

    @Id
    @GeneratedValue
    private Long id;

    private String phoneNumber;

    public Call(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "TEAMMATE")
    public List<Call> teammates;

    public void callsTo(Call call) {
        if (teammates == null) {
            teammates = new ArrayList<>();
        }
        teammates.add(call);
    }

    public String toString() {

        return this.phoneNumber + "'s teammates => "
                + Optional.ofNullable(this.teammates).orElse(
                        Collections.emptyList()).stream()
                .map(Call::getPhoneNumber)
                .collect(Collectors.toList());
    }

}
