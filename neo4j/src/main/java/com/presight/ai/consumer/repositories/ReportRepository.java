//package com.presight.ai.consumer.repositories;
//
//import com.presight.ai.consumer.entities.Report;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
//import org.springframework.data.neo4j.repository.query.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//public interface ReportRepository extends Neo4jRepository<Report, Long> {
//
//    @Query(value = "MATCH (a:Report),(b:Entity)\n" +
//            "WHERE ID(a) = :#{#rid} AND b.name = :#{#entityName}\n" +
//            "CREATE (a)-[r:BELONG]->(b)\n" +
//            "RETURN r\n")
//    @Transactional
//    void createBelongRelationship(@Param("rid") Long rid, @Param("entityName") String entityName);
//}
