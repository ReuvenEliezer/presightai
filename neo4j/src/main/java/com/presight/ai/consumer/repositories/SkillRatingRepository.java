package com.presight.ai.consumer.repositories;

import java.util.List;

import com.presight.ai.consumer.entities.Person;
import com.presight.ai.consumer.entities.SkillRating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface SkillRatingRepository extends Neo4jRepository<SkillRating, Long> {

    @Query("MATCH (p)-[r:RATED]->(skill) WHERE id(p) = :#{#person.id} RETURN p, r, skill")
    List<SkillRating> findAllByPerson(Person person);
}