package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Phone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "Phone", path = "Phone")
public interface PhoneRepository extends Neo4jRepository<Phone, Long> {

//    @Transactional
//    @Query(value = "MATCH (a:Phone),(b:Call) WHERE a.phoneNumber = :#{#phoneNumber} AND ID(b) = :#{#callId} CREATE (a)-[r:CALL]->(b)")
//    void createReportRelationship(@Param("phoneNumber") String phoneNumber, @Param("callId") Long callId);
//
//    @Query("MATCH (p:Phone)<-[r:RATED]-(c:Call) RETURN p,r,c")
//    Collection<Phone> getAllPhones();


    @Query("MATCH p=()-[r:CALLER]->() RETURN p")
    List<Phone> getAllPhone();

    Phone findByPhoneNumber(String phoneNumber);

    @Query("MATCH p=shortestPath((bacon:Person {firstName: $person1FirstName})-[*]-(meg:Person {firstName: $person2FirstName}))\n"
            + "WITH p, [n IN nodes(p) WHERE n:Phone] AS x\n"
            + "UNWIND x AS m\n"
            + "MATCH (m) <-[r:PHONE_OWNER]-(d:Person)\n"
            + "RETURN p, collect(r), collect(d)"
    )
    List<Phone> findAllOnShortestPathBetween(@Param("person1FirstName") String person1FirstName, @Param("person2FirstName") String person2FirstName);
}
