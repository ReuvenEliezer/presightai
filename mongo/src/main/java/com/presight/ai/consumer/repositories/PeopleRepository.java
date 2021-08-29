package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PeopleRepository extends MongoRepository<Person, Long> {

    @Query(value="{ 'first_name' : ?0 }")
    List<Person> findByFirstname(String firstname);
}
