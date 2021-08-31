package com.presight.ai.consumer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    private ObjectMapper objectMapper;


    @KafkaListener(topics = "${kafka.consumer.calls-topic}",
            containerFactory = "kafkaListenerContainerFactory")
    public void callsTopicListener(@Payload String message,
                                    @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
                                    @Header(KafkaHeaders.OFFSET) int offSet,
                                    @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                                    @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partitionId) {
        logger.info("Received Message {} on topic: {}, partitionId: {} offSet={}", message, topicName, partitionId, offSet);
        acknowledgment.acknowledge();
    }

}
