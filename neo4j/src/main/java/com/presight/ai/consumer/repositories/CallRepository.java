//package com.presight.ai.consumer.repositories;
//
//import com.presight.ai.consumer.entities.Call;
//import com.presight.ai.consumer.entities.Phone;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
//import org.springframework.data.neo4j.repository.query.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface CallRepository extends Neo4jRepository<Call, Long> {
//
//    @Query("MATCH p=shortestPath((bacon:Phone {phoneNumber: $phoneNum1})-[*]-(meg:Phone {phoneNumber: $phoneNum2}))\n"
//            + "WITH p, [n IN nodes(p) WHERE n:Call] AS x\n"
//            + "UNWIND x AS m\n"
//            + "MATCH (m) <-[r:CALLER]-(d:Phone)\n"
//            + "RETURN p, collect(r), collect(d)"
//    )
//    List<Call> findAllOnShortestPathBetween(@Param("phoneNum1") String phoneNum1, @Param("phoneNum2") String phoneNum2);
//
//}
