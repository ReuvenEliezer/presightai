package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//import com.presight.ai.consumer.entities.Person;
//import com.presight.ai.consumer.entities.SkillRating;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    //    @Query("MATCH (a:Person)-[:PHONE_OWNER]->(b:Phone) WHERE a.firstName = :#{#firstName} RETURN a,b")
//    List<Person> findByFirstName(String firstName);
//
    @Query("MATCH (a:Person),(b:Phone),(c:Call) WHERE a.firstName = :#{#firstName} RETURN a,b,c")
    List<Person> findByFirstName(String firstName);

    @Query("MATCH p=shortestPath((bacon:Person {firstName: $person1FirstName})-[*]-(meg:Person {firstName: $person2FirstName})) RETURN p")
    List<Person> findAllOnShortestPathBetween(@Param("person1FirstName") String person1FirstName, @Param("person2FirstName") String person2FirstName);

//    @Query("MATCH (p)-[r:RATED]->(skill) WHERE id(p) = :#{#person.id} RETURN p, r, skill")
//    List<SkillRating> findAllByPerson(Person person);
}