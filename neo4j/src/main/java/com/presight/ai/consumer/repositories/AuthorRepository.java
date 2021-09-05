package com.presight.ai.consumer.repositories;

import java.util.List;

import com.presight.ai.consumer.entities.Author;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends Neo4jRepository<Author, Long> {

    @Query("MATCH (au:Author)<-[a:AUTHORED]-(b:Book) RETURN au,a,b")
    List<Author> getAllAuthors();
}