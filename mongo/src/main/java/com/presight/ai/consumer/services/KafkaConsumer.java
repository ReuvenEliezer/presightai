package com.presight.ai.consumer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.presight.ai.consumer.entities.Person;
import com.presight.ai.consumer.repositories.PeopleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LogManager.getLogger(KafkaConsumer.class);

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @KafkaListener(topics = "${kafka.consumer.topic}",
            groupId = "${kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void peopleTopicListener(@Payload String message,
                                    @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
                                    @Header(KafkaHeaders.OFFSET) int offSet,
                                    @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                                    @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partitionId) {
        logger.info("Received Message {} on topic: {}, partitionId: {} offSet={}", message, topicName, partitionId, offSet);
        Person person;
        try {
            person = objectMapper.readValue(message, Person.class);
        } catch (JsonProcessingException e) {
            logger.error("error while read message '{}' to person entity. Exception: ", message, e);
            throw new RuntimeException(e);
        }
        savePersonByPhone(person);
        acknowledgment.acknowledge();
    }

    private void savePersonByPhone(Person person) {
        /**
         * https://docs.mongodb.com/manual/core/index-single/
         * https://stackoverflow.com/questions/9730136/how-to-create-a-nested-index-in-mongodb/9730214
         */
        person.getPhoneList().forEach(p -> {
            //TODO save each person by phone num ??
        });
        person = peopleRepository.save(person);
        logger.info("person {} entity saved successful", person.toString());
    }


}
