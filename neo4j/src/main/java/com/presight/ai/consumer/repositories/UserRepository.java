//package com.presight.ai.consumer.repositories;
//
//import com.presight.ai.consumer.entities.User;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
//import org.springframework.data.neo4j.repository.query.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collection;
//
//public interface UserRepository extends Neo4jRepository<User, Long> {
//
////    @Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
////    Collection<User> getAllUsers();
//
//
//    @Query(value = "MATCH (a:User),(b:Report)\n" +
//            "WHERE a.username = :#{#username} AND ID(b) = :#{#reportId}\n" +
//            "CREATE (a)-[r:REPORT]->(b)")
//    @Transactional
//    void createReportRelationship(@Param("username") String username, @Param("reportId") Long reportId);
//
//}
