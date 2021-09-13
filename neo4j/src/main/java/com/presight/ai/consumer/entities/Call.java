package com.presight.ai.consumer.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

@Data
@Builder
@NoArgsConstructor// Empty constructor required as of Neo4j API 2.0.5
@AllArgsConstructor
//@RelationshipProperties
@Node("Call")
public class Call extends BaseEntity {

    private String fromPhoneNum;
    private String toPhoneNum;
    private LocalDateTime calTime;
    private Duration callDuration;
    private RegineTypeEnum regineFrom;
    private RegineTypeEnum regineTo;

//    @TargetNode
//    private Phone phone;

//    private String provider; // TODO?

}


