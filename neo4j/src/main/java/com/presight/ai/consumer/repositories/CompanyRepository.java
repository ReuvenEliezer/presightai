package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Car;
import com.presight.ai.consumer.entities.Company;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CompanyRepository extends Neo4jRepository<Company, Long> {
}
