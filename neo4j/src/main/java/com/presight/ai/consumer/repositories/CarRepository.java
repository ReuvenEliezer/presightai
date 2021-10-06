package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Car;
import com.presight.ai.consumer.entities.Movie;
import com.presight.ai.consumer.entities.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends Neo4jRepository<Car, Long> {

    @Query("MATCH (c:Car)-[r:OWNER]->(p:Person) WHERE c.color = $color RETURN c,r,p")
    List<Car> findAllByColor(String color);


}
