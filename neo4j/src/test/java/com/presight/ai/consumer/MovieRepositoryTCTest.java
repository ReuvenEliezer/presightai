package com.presight.ai.consumer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.presight.ai.consumer.entities.*;
import com.presight.ai.consumer.repositories.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.Neo4jContainer;

//@DataNeo4jTest
@SpringBootTest
@RunWith(SpringRunner.class)
public class MovieRepositoryTCTest {


//    private static Neo4jContainer<?> neo4jContainer;

//    @Autowired
//    private Neo4jClient client;

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    @Autowired
    private MovieRepository movieRepository;

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ReportRepository reportRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

//    @Before
//    public void initializeNeo4j() {
//
//        neo4jContainer = new Neo4jContainer<>("neo4j:latest");
////                .withAdminPassword("somePassword");
//        neo4jContainer.start();
//    }
//
//    @After
//    public void stopNeo4j() {
//        neo4jContainer.close();
//    }

    @Test
    public void t2() {
        authorRepository.deleteAll();
        bookRepository.deleteAll();

        Book book1 = new Book("Invisible Man", "English");
        Book book2 = new Book("Moby Dick", "English");
        Book book3 = new Book("Hamlet", "English");
        bookRepository.saveAll(Arrays.asList(book1, book2, book3));

        authorRepository.save(new Author("Ralph Ellison", Collections.singletonList(book1)));
        authorRepository.save(new Author("William Shakespeare", Collections.singletonList(book2)));
        authorRepository.save(new Author("Herman Melville", Collections.singletonList(book3)));
        /**
         * CREATE (Invisible_Man:Book {title: 'Invisible Man', language: 'English'})
         * CREATE (Moby_Dick:Book {title: 'Moby Dick', language: 'English'})
         * CREATE (Hamlet:Book {title: 'Hamlet', language: 'English'})
         * CREATE (Ellison:Author {name: 'Ralph Ellison'})
         * CREATE (Shakespeare:Author {name: 'William Shakespeare'})
         * CREATE (Melville:Author {name: 'Herman Melville'})
         *
         * CREATE
         * (Invisible_Man)-[:AUTHORED]->(Ellison),
         * (Moby_Dick)-[:AUTHORED]->(Melville),
         * (Hamlet)-[:AUTHORED]->(Shakespeare)
         * ;
         */
        List<Author> allAuthors = authorRepository.getAllAuthors();
        List<Book> h = bookRepository.findByTitleContaining("a");
        List<Book> allBooks = bookRepository.getAllBooks();
        Book hamlet = bookRepository.findByTitle("Hamlet");
        List<Book> english = bookRepository.findByLanguage("English");
    }

//    @Test
//    public void t1() {
//        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//
//
//        Report report = new Report();
//        report.setTitle("titel");
//        report.setDescription("Description");
//        report.setDate(formatter.format(new Date()));
//
//        Report newReport = reportRepository.save(report);
//
//        userRepository.createReportRelationship("userName", newReport.getId());
//        reportRepository.createBelongRelationship(newReport.getId(), "EntityName");
//
//    }

    @Test
    public void shouldSaveAndReadEntities() {

        Movie movie = new Movie("The Love Bug",
                "A movie that follows the adventures of Herbie, Herbie's driver, "
                        + "Jim Douglas (Dean Jones), and Jim's love interest, " + "Carole Bennett (Michele Lee)");

        Person person1 = new Person(1931, "Dean Jones");
        Person person2 = new Person(1942, "Michele Lee");
        Role roles1 = new Role(person1, Collections.singletonList("Didi"));
        Role roles2 = new Role(person2, Collections.singletonList("Michi"));
        movie.getActorsAndRoles().add(roles1);
        movie.getActorsAndRoles().add(roles2);

        movieRepository.save(movie);
        List<Movie> all = movieRepository.findAll();
//        neo4jTemplate.save(movie);

        Optional<Person> person = neo4jTemplate.findById(person1.getId(), Person.class);
        Optional<Movie> byId = movieRepository.findById(person1.getId());
        List<Movie> allOnShortestPathBetween = movieRepository.findAllOnShortestPathBetween(person1.getId(), person2.getId());

//        assertThat(person).map(PersonEntity::getBorn).hasValue(1931);

//        assertThat(neo4jTemplate.count(PersonEntity.class)).isEqualTo(2L);
    }

//    @DynamicPropertySource
//    public void neo4jProperties(DynamicPropertyRegistry registry) {
//
//        registry.add("spring.data.neo4j.uri", neo4jContainer::getBoltUrl);
//        registry.add("spring.data.neo4j.username", () -> "neo4j");
//        registry.add("spring.data.neo4j.password", () -> "secret");
//    }
//
//    @Test
//    public void findSomethingShouldWork() {
//
//        Optional<Long> result = client.query("MATCH (n) RETURN COUNT(n)")
//                .fetchAs(Long.class)
//                .one();
//        Assert.assertEquals(0l, result.get().longValue());
//    }
}