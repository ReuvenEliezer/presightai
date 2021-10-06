package com.presight.ai.consumer;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.presight.ai.consumer.entities.*;
import com.presight.ai.consumer.repositories.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Autowired
    private CarRepository carRepository;

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

        Call person1Phone1Call1 = createCall(person1.getPhones().get(0), person2.getPhones().get(0), LocalDateTime.now().minusHours(2), Duration.ofMinutes(10), RegineTypeEnum.ISRAEL, RegineTypeEnum.UK);
        Call person1Phone1Call2 = createCall(person1.getPhones().get(0), person2.getPhones().get(0), LocalDateTime.now().minusHours(1), Duration.ofMinutes(20), RegineTypeEnum.US, RegineTypeEnum.US);
        Call person1Phone2Call1 = createCall(person1.getPhones().get(1), person2.getPhones().get(0), LocalDateTime.now().minusDays(5), Duration.ofMinutes(30), RegineTypeEnum.US, RegineTypeEnum.ISRAEL);
        phoneRepository.save(person2.getPhones().get(0));

        person1.getPhones().get(0).setCalls(Arrays.asList(person1Phone1Call1, person1Phone1Call2));
        phoneRepository.save(person1.getPhones().get(0));
        person1.getPhones().get(1).setCalls(Collections.singletonList(person1Phone2Call1));
        phoneRepository.save(person1.getPhones().get(1));

        Call call3 = createCall(person2.getPhones().get(0), person1.getPhones().get(0), LocalDateTime.now().minusHours(2), Duration.ofMinutes(40), RegineTypeEnum.ISRAEL, RegineTypeEnum.US);
        person2.getPhones().get(0).setCalls(Collections.singletonList(call3));
        phoneRepository.save(person2.getPhones().get(0));

        Phone byPhoneNumber = phoneRepository.findByPhoneNumber(person1.getPhones().get(0).getPhoneNumber());
        Assert.assertNotNull(byPhoneNumber);

        Slice<Phone> allOnShortestPathBetween = phoneRepository.findAllOnShortestPathBetween(person1.getFirstName(), person2.getFirstName(), Pageable.ofSize(1000));
        List<Phone> allPhone = phoneRepository.getAllPhone();
        List<Person> byFirstName = personRepository.findByFirstName(person1.getFirstName());
        Slice<Person> allOnShortestPathBetween1 = personRepository.findAllOnShortestPathBetween(person1.getFirstName(), person2.getFirstName(), Pageable.ofSize(1000));
//        Slice<Person> sliceByName = personRepository.findSliceByName("person 1", Pageable.ofSize(10));
//        List<Call> all = callRepository.findAll();
//        List<Call> allOnShortestPathBetween1 = callRepository.findAllOnShortestPathBetween(person1Phone1.getPhoneNumber(), person2Phone1.getPhoneNumber());
//        List<Call> allOnShortestPathBetween11 = callRepository.findAllOnShortestPathBetween(person2Phone1.getPhoneNumber(), person1Phone1.getPhoneNumber());
//        List<Call> allOnShortestPathBetween12 = callRepository.findAllOnShortestPathBetween(person1Phone2.getPhoneNumber(), person2Phone1.getPhoneNumber());
    }

    @Test
    public void allEntitiesTest() {
        carRepository.deleteAll();
        phoneRepository.deleteAll();
        personRepository.deleteAll();
        Phone person1Phone1 = Phone.builder()
                .phoneNumber("+97254...")
                .build();
        Phone person1Phone2 = Phone.builder()
                .phoneNumber("+97250...")
                .build();

        Car carPerson1 = Car.builder()
                .color(ColorEnum.RED)
                .build();
        Person person1 = Person.builder()
                .firstName("person 1")
                .birthday(LocalDate.ofYearDay(2020, 1))
                .phones(Arrays.asList(person1Phone1, person1Phone2))
                .cars(Arrays.asList(carPerson1))
                .build();
        person1 = personRepository.save(person1);
        carPerson1.setPerson(person1);
//        carPerson1 = carRepository.save(carPerson1);

        Phone person2Phone1 = Phone.builder()
                .phoneNumber("+97252")
                .build();

        Car car1Person2 = Car.builder()
                .color(ColorEnum.BLUE)
                .build();

        Car car2Person2 = Car.builder()
                .color(ColorEnum.RED)
                .build();

        Person person2 = Person.builder()
                .firstName("person 2")
                .birthday(LocalDate.ofYearDay(2010, 1))
                .phones(Collections.singletonList(person2Phone1))
                .cars(Arrays.asList(car1Person2, car2Person2))
                .build();

        person2 = personRepository.save(person2);
        car1Person2.setPerson(person2);
//        car1Person2 = carRepository.save(car1Person2);

        car2Person2.setPerson(person2);
//        car2Person2 = carRepository.save(car2Person2);

        Call person1Phone1Call1 = createCall(person1.getPhones().get(0), person2.getPhones().get(0), LocalDateTime.now().minusHours(2), Duration.ofMinutes(10), RegineTypeEnum.ISRAEL, RegineTypeEnum.UK);
        Call person1Phone1Call2 = createCall(person1.getPhones().get(0), person2.getPhones().get(0), LocalDateTime.now().minusHours(1), Duration.ofMinutes(20), RegineTypeEnum.US, RegineTypeEnum.US);
        Call person1Phone2Call1 = createCall(person1.getPhones().get(1), person2.getPhones().get(0), LocalDateTime.now().minusDays(5), Duration.ofMinutes(30), RegineTypeEnum.US, RegineTypeEnum.ISRAEL);
        phoneRepository.save(person2.getPhones().get(0));

        person1.getPhones().get(0).setCalls(Arrays.asList(person1Phone1Call1, person1Phone1Call2));
        phoneRepository.save(person1.getPhones().get(0));
        person1.getPhones().get(1).setCalls(Collections.singletonList(person1Phone2Call1));
        phoneRepository.save(person1.getPhones().get(1));

        Call call3 = createCall(person2.getPhones().get(0), person1.getPhones().get(0), LocalDateTime.now().minusHours(2), Duration.ofMinutes(40), RegineTypeEnum.ISRAEL, RegineTypeEnum.US);
        person2.getPhones().get(0).setCalls(Collections.singletonList(call3));
        phoneRepository.save(person2.getPhones().get(0));

        Phone byPhoneNumber = phoneRepository.findByPhoneNumber(person1.getPhones().get(0).getPhoneNumber());
        Assert.assertNotNull(byPhoneNumber);

        Slice<Phone> allOnShortestPathBetween = phoneRepository.findAllOnShortestPathBetween(person1.getFirstName(), person2.getFirstName(), Pageable.ofSize(1));
        List<Phone> allPhone = phoneRepository.getAllPhone();
        List<Person> byFirstName = personRepository.findByFirstName(person1.getFirstName());
        Slice<Person> allOnShortestPathBetween1 = personRepository.findAllOnShortestPathBetween(person1.getFirstName(), person2.getFirstName(), Pageable.ofSize(1));
//        List<Call> all = callRepository.findAll();
//        List<Call> allOnShortestPathBetween1 = callRepository.findAllOnShortestPathBetween(person1Phone1.getPhoneNumber(), person2Phone1.getPhoneNumber());
//        List<Call> allOnShortestPathBetween11 = callRepository.findAllOnShortestPathBetween(person2Phone1.getPhoneNumber(), person1Phone1.getPhoneNumber());
//        List<Call> allOnShortestPathBetween12 = callRepository.findAllOnShortestPathBetween(person1Phone2.getPhoneNumber(), person2Phone1.getPhoneNumber());

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
//                .directors(Arrays.asList(person1,person2))
                .build();
        movie = movieRepository.save(movie);
        person1.setReviewed(Collections.singletonList(movie));
        personRepository.save(person1);
        person2.setReviewed(Collections.singletonList(movie));
        personRepository.save(person2);
        List<Movie> all = movieRepository.findAll();
//        neo4jTemplate.save(movie);

        Optional<Person> person = neo4jTemplate.findById(person1.getId(), Person.class);
        List<Movie> allOnShortestPathBetween11 = movieRepository.findAllOnShortestPathBetween(person1.getId(), person2.getId());

        List<Car> red1 = carRepository.findAllByColor(ColorEnum.RED.name());
        List<Person> red = personRepository.findAllByCarColor(ColorEnum.BLUE.name());
        List<Person> all1 = personRepository.findAll();
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

        Call call1 = createCall(caller, called, LocalDateTime.now(), Duration.ofMinutes(10), RegineTypeEnum.ISRAEL, RegineTypeEnum.UK);
        Call call2 = createCall(caller, called, LocalDateTime.now().minusHours(1), Duration.ofMinutes(20), RegineTypeEnum.US, RegineTypeEnum.US);
        phoneRepository.save(called);

        caller.setCalls(Arrays.asList(call1, call2));
        phoneRepository.save(caller);
    }

    private Call createCall(Phone caller, Phone called, LocalDateTime now, Duration callDuration, RegineTypeEnum regineFrom, RegineTypeEnum regineTo) {
        return Call.builder()
                .phone(called)
                .fromPhoneNum(caller.getPhoneNumber())
                .toPhoneNum(called.getPhoneNumber())
                .calTime(now)
                .callDuration(callDuration)
                .regineFrom(regineFrom)
                .regineTo(regineTo)
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
//        List<Map<String, Object>> graph = movieRepository.graph(10);
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