package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Movie;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    @Query("MATCH p=shortestPath((bacon:Person {id: $person1})-[*]-(meg:Person {id: $person2}))\n"
            + "WITH p, [n IN nodes(p) WHERE n:Movie] AS x\n"
            + "UNWIND x AS m\n"
            + "MATCH (m) <-[r:DIRECTED]-(d:Person)\n"
            + "RETURN p, collect(r), collect(d)"
    )
    List<Movie> findAllOnShortestPathBetween(@Param("person1") Long person1, @Param("person2") Long person2);

    Movie findOneByTitle(String title);
}
