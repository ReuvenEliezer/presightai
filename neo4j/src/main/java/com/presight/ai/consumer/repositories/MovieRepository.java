package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Movie;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    @Query("MATCH p=shortestPath((bacon:Person {id: $person1})-[*]-(meg:Person {id: $person2}))\n"
            + "WITH p, [n IN nodes(p) WHERE n:Movie] AS x\n"
            + "UNWIND x AS m\n"
            + "MATCH (m) <-[r:REVIEWED]-(d:Person)\n"
            + "RETURN p, collect(r), collect(d)"
    )
    List<Movie> findAllOnShortestPathBetween(@Param("person1") Long person1, @Param("person2") Long person2);

//    @Query("MATCH (m:Movie {title: $movie.__id__})\n"
//            + "MATCH (m) <- [r:DIRECTED|REVIEWED|ACTED_IN] - (p:Person)\n"
//            + "return m, collect(r), collect(p)")
//    Movie findByMovie(@Param("movie") Movie movie);

    Movie findOneByTitle(String title);

//    @Query("MATCH (m:Movie)<-[:ACTED_IN]-(a:Person) RETURN m.title as movie, collect(a.firstName) as cast LIMIT $limit")
//    List<Map<String, Object>> graph(int limit);
}
