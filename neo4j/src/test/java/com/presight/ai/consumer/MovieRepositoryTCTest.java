package com.presight.ai.consumer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
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

    @Autowired
    private PersonRepository personRepository;

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ReportRepository reportRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PhoneRepository phoneRepository;

//    @Autowired
//    private CallRepository callRepository;

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

//    @Test
//    public void callsTest() {
//        phoneRepository.deleteAll();
//        callRepository.deleteAll();
//
//        Call call = Call.builder()
//                .fromPhoneNum("+972505777777")
//                .toPhoneNum("+972505111111")
//                .callDuration(Duration.ofMinutes(20))
//                .calTime(LocalDateTime.now(ZoneOffset.UTC).minus(Duration.ofHours(1)))
//                .build();
//        callRepository.save(call);
//        Phone phoneFrom = Phone.builder()
//                .phoneNumber(call.getFromPhoneNum())
//                .calls(Collections.singletonList(call))
//                .build();
//
//        Phone phoneTo = Phone.builder()
//                .phoneNumber(call.getToPhoneNum())
//                .build();
////        phoneRepository.findAll().stream().filter(p->p.getPhoneNumber().equals(call.ro))
//
//        phoneRepository.save(phoneTo);
//        phoneRepository.save(phoneFrom);
//
//        List<Phone> phones = phoneRepository.findAll();
//        List<Call> calls = callRepository.findAll();
////        Collection<Phone> allPhones = phoneRepository.getAllPhones();
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
        List<Author> allAuthors1 = authorRepository.findAll();

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
    public void multipleCallsTest() {
        phoneRepository.deleteAll();
        personRepository.deleteAll();
        Phone person1Phone1 = Phone.builder()
                .phoneNumber("+97254...")
                .build();
        Phone person1Phone2 = Phone.builder()
                .phoneNumber("+97250...")
                .build();
        Person person1 = Person.builder()
                .firstName("person 1")
                .birthday(LocalDate.ofYearDay(2020, 1))
                .phones(Arrays.asList(person1Phone1, person1Phone2))
                .build();
        personRepository.save(person1);


        Phone person2Phone1 = Phone.builder()
                .phoneNumber("+97252")
                .build();

        Person person2 = Person.builder()
                .firstName("person 2")
                .birthday(LocalDate.ofYearDay(2010, 1))
                .phones(Collections.singletonList(person2Phone1))
                .build();

        personRepository.save(person2);

        Call person1Phone1Call1 = createCall(person1.getPhones().get(0), person2.getPhones().get(0), LocalDateTime.now().minusHours(2), 10, RegineTypeEnum.ISRAEL, RegineTypeEnum.UK);
        Call person1Phone1Call2 = createCall(person1.getPhones().get(0), person2.getPhones().get(0), LocalDateTime.now().minusHours(1), 20, RegineTypeEnum.US, RegineTypeEnum.US);
        Call person1Phone2Call1 = createCall(person1.getPhones().get(1), person2.getPhones().get(0), LocalDateTime.now().minusDays(5), 30, RegineTypeEnum.US, RegineTypeEnum.ISRAEL);
        phoneRepository.save(person2.getPhones().get(0));

        person1.getPhones().get(0).setCalls(Arrays.asList(person1Phone1Call1, person1Phone1Call2));
        phoneRepository.save(person1.getPhones().get(0));
        person1.getPhones().get(1).setCalls(Collections.singletonList(person1Phone2Call1));
        phoneRepository.save(person1.getPhones().get(1));

        Call call3 = createCall(person2.getPhones().get(0), person1.getPhones().get(0), LocalDateTime.now().minusHours(2), 40, RegineTypeEnum.ISRAEL, RegineTypeEnum.US);
        person2.getPhones().get(0).setCalls(Collections.singletonList(call3));
        phoneRepository.save(person2.getPhones().get(0));


        Phone byPhoneNumber = phoneRepository.findByPhoneNumber(person1.getPhones().get(0).getPhoneNumber());
        Assert.assertNotNull(byPhoneNumber);
    }


    @Test
    public void callTest() {
        phoneRepository.deleteAll();

        Phone caller = Phone.builder()
                .phoneNumber("from +972...")
                .build();

        Phone called = Phone.builder()
                .phoneNumber("to +972...")
                .build();

        Call call1 = createCall(caller, called, LocalDateTime.now(), 10, RegineTypeEnum.ISRAEL, RegineTypeEnum.UK);
        Call call2 = createCall(caller, called, LocalDateTime.now().minusHours(1), 20, RegineTypeEnum.US, RegineTypeEnum.US);
        phoneRepository.save(called);

        caller.setCalls(Arrays.asList(call1, call2));
        phoneRepository.save(caller);
    }

    private Call createCall(Phone caller, Phone called, LocalDateTime now, int i, RegineTypeEnum israel, RegineTypeEnum uk) {
        return Call.builder()
                .phone(called)
                .fromPhoneNum(caller.getPhoneNumber())
                .toPhoneNum(called.getPhoneNumber())
                .calTime(now)
                .callDuration(Duration.ofMinutes(i))
                .regineFrom(israel)
                .regineTo(uk)
                .build();
    }

    @Test
    public void movieTest() {

        personRepository.deleteAll();
        movieRepository.deleteAll();


        Person person1 = Person.builder()
                .firstName("person1")
                .birthday(LocalDate.ofYearDay(1950, 1))
                .build();
        Person person2 = Person.builder()
                .firstName("person 2")
                .birthday(LocalDate.ofYearDay(1970, 1))
                .build();
        person1 = personRepository.save(person1);
        person2 = personRepository.save(person2);
        Actor actor1 = Actor.builder()
                .roles(Arrays.asList("actor 1 role", "actor2"))
                .person(person1)
                .build();

        Actor actor2 = Actor.builder()
                .roles(Collections.singletonList("actor 2 role"))
                .person(person2)
                .build();

        Movie movie = Movie.builder()
                .title("title")
                .description("description")
                .actors(Collections.singletonList(actor1))
                .build();
        movie = movieRepository.save(movie);
        person1.setReviewed(Collections.singletonList(movie));
        personRepository.save(person1);
        person2.setReviewed(Collections.singletonList(movie));
        personRepository.save(person2);
        List<Movie> all = movieRepository.findAll();
//        neo4jTemplate.save(movie);

        Optional<Person> person = neo4jTemplate.findById(person1.getId(), Person.class);
        List<Movie> allOnShortestPathBetween = movieRepository.findAllOnShortestPathBetween(person1.getId(), person2.getId());
        Movie title = movieRepository.findOneByTitle("title");
//        assertThat(person).map(PersonEntity::getBorn).hasValue(1931);

//        assertThat(neo4jTemplate.count(PersonEntity.class)).isEqualTo(2L);
    }

    @Test
    public void shouldSaveAndReadEntities() {

        Movie movie = Movie.builder()
                .title("title")
                .description("description")
                .build();

        Person person1 = Person.builder()
                .firstName("person1")
                .birthday(LocalDate.ofYearDay(1950, 1))
                .build();
        Person person2 = Person.builder()
                .firstName("person 2")
                .birthday(LocalDate.ofYearDay(1970, 1))
                .build();
        Role roles1 = new Role(person1, Collections.singletonList("Didi"));
        Role roles2 = new Role(person2, Collections.singletonList("Michi"));
//        movie.getActorsAndRoles().add(roles1);
//        movie.getActorsAndRoles().add(roles2);

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