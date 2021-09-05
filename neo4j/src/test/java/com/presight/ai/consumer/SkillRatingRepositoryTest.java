//package com.presight.ai.consumer;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//
//import com.presight.ai.consumer.entities.Person;
//import com.presight.ai.consumer.entities.Skill;
//import com.presight.ai.consumer.entities.SkillRating;
//import com.presight.ai.consumer.repositories.PersonRepository;
//import com.presight.ai.consumer.repositories.SkillRatingRepository;
//import com.presight.ai.consumer.repositories.SkillRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.neo4j.driver.internal.InternalRelationship;
//import org.neo4j.driver.internal.value.RelationshipValue;
//import org.neo4j.driver.types.Relationship;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.support.TransactionTemplate;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class SkillRatingRepositoryTest {
//
//    @Autowired
//    private SkillRatingRepository skillRatingRepository;
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Autowired
//    private SkillRepository skillRepository;
//
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @Before
//    void setUp(){
//        personRepository.deleteAll();
//        skillRepository.deleteAll();
//        skillRatingRepository.deleteAll();
//    }
//
//    @Test
//    public void retrievalOfSkillsShouldWork() {
//
//
//        Skill s1 = Skill.builder()
//                .name("Java")
//                .description("The Number one programming language everyone loves and hates")
//                .build();
//
//        Skill s = Skill.builder()
//                .name("Python")
//                .description("The Number two programming language everyone loves and hates")
//                .build();
//        Skill skillSaved = skillRepository.save(s);
////        new TransactionTemplate(transactionManager).execute(t -> {
////            session.purgeDatabase();
////            return null;
////        });
//
//
//        SkillRating r1 = SkillRating.builder()
//                .skill(skillSaved)
//                .measurementDate(LocalDate.now())
//                .score(23)
//                .build();
//
//        SkillRating skillRating1Saved = skillRatingRepository.save(r1);
//        SkillRating r2 = SkillRating.builder()
//                .skill(skillSaved)
//                .measurementDate(LocalDate.now())
//                .score(42)
//                .build();
//
//        SkillRating skillRating2Saved = skillRatingRepository.save(r2);
//
//        Person person1 = Person.builder()
//                .firstName("Michael")
//                .lastName("Simons")
//                .email("person1@gmail.com")
//                .birthday(LocalDate.now().minusYears(1))
//                .relationshipValue(skillRating1Saved)
//                .build();
//
//        Person person2 = Person.builder()
//                .firstName("p")
//                .lastName("M")
//                .email("person2@gmail.com")
//                .birthday(LocalDate.now().minusYears(3))
//                .relationshipValue(skillRating2Saved)
//                .build();
//
//        personRepository.saveAll(Arrays.asList(person1, person2));
//        List<Person> all1 = personRepository.findAll();
//
//        List<Person> all2 = personRepository.findAll();
//        List<SkillRating> all = skillRatingRepository.findAll();
//        List<SkillRating> skillRatings = skillRatingRepository.findAllByPerson(person2);
//    }
//
//}