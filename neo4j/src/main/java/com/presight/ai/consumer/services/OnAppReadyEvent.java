//package com.presight.ai.consumer.services;
//
//import com.presight.ai.consumer.entities.*;
////import com.presight.ai.consumer.repositories.CallRepository;
//import com.presight.ai.consumer.repositories.MovieRepository;
////import com.presight.ai.consumer.repositories.PhoneRepository;
//import com.presight.ai.consumer.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.Collection;
//import java.util.List;
//
//@Component
//public class OnAppReadyEvent implements ApplicationListener<ApplicationReadyEvent> {
//
//
////    @Autowired
////    private PhoneRepository phoneRepository;
//
////    @Autowired
////    private CallRepository callRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private MovieRepository movieRepository;
//
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
////        callRepository.deleteAll();
////        phoneRepository.deleteAll();
//        Phone phoneFrom = new Phone("+972501234567");
////        phoneRepository.save(phoneFrom);
//        Phone phoneTo = new Phone("+972500000000");
////        phoneRepository.save(phoneTo);
////        Call call = new Call(phoneFrom.getPhoneNumber(), phoneTo.getPhoneNumber(), LocalDateTime.now(), Duration.ofHours(1), RegineTypeEnum.ISRAEL, RegineTypeEnum.US);
////        Call callSaved = callRepository.save(call);
//
////        phoneRepository.createReportRelationship(callSaved.getFromPhoneNum(), callSaved.getId());
//
////        Phone phone = new Phone("+972501234567");
////        phone.addPhoneDestination(new Phone("+972500000000"));
//
////        Iterable<Call> all1 = callRepository.findAll();
////        Iterable<Phone> all = phoneRepository.findAll();
////        Collection<Phone> allPhones = phoneRepository.getAllPhones();
//
//
//        Movie movie1 = new Movie();
//        movie1.setTitle("m1");
//        movie1.setDirector("d1");
//        movieRepository.save(movie1);
//
//
//        Movie movie2 = new Movie();
//        movie2.setTitle("m2");
//        movie2.setDirector("d2");
//        movieRepository.save(movie2);
//
//        User user1 = new User();
//        user1.setName("Peter");
//        user1.setAge(30d);
//        userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setName("Sam");
//        user2.setAge(20d);
//        userRepository.save(user2);
//
//        User user3 = new User();
//        user3.setName("Ron");
//        user3.setAge(35d);
//        userRepository.save(user3);
//
//        Collection<User> allUsers = userRepository.getAllUsers();
//
//
//    }
//}
