package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Entity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EntityRepository extends Neo4jRepository<Entity, Long> {
}
