package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Person;
import com.presight.ai.consumer.entities.Skill;
import com.presight.ai.consumer.entities.SkillRating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface SkillRepository extends Neo4jRepository<Skill, Long> {

}