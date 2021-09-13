package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

//
//import com.presight.ai.consumer.entities.Person;
//import com.presight.ai.consumer.entities.SkillRating;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
//import org.springframework.data.neo4j.repository.query.Query;
//
//import java.util.List;
//
public interface PersonRepository extends Neo4jRepository<Person, Long> {

//    @Query("MATCH (p)-[r:RATED]->(skill) WHERE id(p) = :#{#person.id} RETURN p, r, skill")
//    List<SkillRating> findAllByPerson(Person person);
}