package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Call;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CallRepository extends Neo4jRepository<Call, Long> {

    Call findByPhoneNumber(String phoneNumber);

    List<Call> findByTeammatesPhoneNumber(String phoneNumber);
}
