package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//import com.presight.ai.consumer.entities.Person;
//import com.presight.ai.consumer.entities.SkillRating;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    //    @Query("MATCH (a:Person)-[:PHONE_OWNER]->(b:Phone) WHERE a.firstName = :#{#firstName} RETURN a,b")
    List<Person> findByFirstName(String firstName);

    @Query("MATCH p=shortestPath((bacon:Person {firstName: $person1FirstName})-[*]-(meg:Person {firstName: $person2FirstName})) RETURN p LIMIT $limit")
    Slice<Person> findAllOnShortestPathBetween(String person1FirstName, String person2FirstName, Pageable pageable);

//    @Query("MATCH (p)-[r:RATED]->(skill) WHERE id(p) = :#{#person.id} RETURN p, r, skill")
//    List<SkillRating> findAllByPerson(Person person);

//    @Query("MATCH (n:Person) WHERE n.name = $name RETURN n :#{orderBy(#pageable)} SKIP $skip LIMIT $limit")
//    Slice<Person> findSliceByName(String name, Pageable pageable);

//    @Query("MATCH (n:Person) WHERE n.name = $name RETURN n :#{orderBy(#sort)}")
//    List<Person> findAllByName(String name, Sort sort);


    @Query("MATCH (p:Person)-[r:CARS]->(c:Car) WHERE c.color = $color RETURN DISTINCT p,r,c")
    List<Person> findAllByCarColor(String color);

}