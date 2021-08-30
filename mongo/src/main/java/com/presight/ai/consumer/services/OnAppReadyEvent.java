//package com.presight.ai.consumer.services;
//
//import com.mongodb.client.*;
//import com.mongodb.client.model.IndexModel;
//import com.presight.ai.consumer.entities.Person;
//import com.presight.ai.consumer.repositories.PeopleRepository;
//import org.bson.BsonDocument;
//import org.bson.Document;
//import org.bson.conversions.Bson;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//@Component
//public class OnAppReadyEvent implements ApplicationListener<ApplicationReadyEvent> {
//
//    @Autowired
//    private PeopleRepository peopleRepository;
//
//    @Autowired
//    private MongoOperations mongoOperations;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//        peopleRepository.deleteAll();
//        Person person = new Person();
//        person.setId(1l);
//        person.setFirstName("a");
//        person = peopleRepository.save(person);
//        Person person1 = new Person();
//        person1.setId(1l);
//        person1.setFirstName("aa");
//        person1 = peopleRepository.save(person1);
//        List<Person> all = peopleRepository.findAll();
//        Set<String> collectionNames = mongoTemplate.getCollectionNames();
//        MongoDatabase db = mongoTemplate.getDb();
//        MongoCollection<Document> mongoCollection = db.getCollection("person");
//
//        for (Document document : mongoCollection.listIndexes()) {
//            String s = document.toJson();
//            Collection<Object> values = document.values();
//        }
//        ListCollectionsIterable<Document> documents = db.listCollections();
//        MongoIterable<String> strings = db.listCollectionNames();
//    }
//}
