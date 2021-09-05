package com.presight.ai.consumer;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.presight.ai.consumer.entities.Movie;
import com.presight.ai.consumer.entities.Person;
import com.presight.ai.consumer.entities.Role;
import com.presight.ai.consumer.repositories.MovieRepository;
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