package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface BookRepository extends Neo4jRepository<Book, Long> {

    Book findByTitle(String title);

    List<Book> findByLanguage(String language);

    @Query("MATCH (b:Book) RETURN b")
    List<Book> getAllBooks();

    @Query("MATCH (b:Book) WHERE b.title =~ ('(?i).*'+$str+'.*') RETURN b")
    List<Book> findByTitleContaining(String str);
}
