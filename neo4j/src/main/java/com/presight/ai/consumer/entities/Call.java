//package com.presight.ai.consumer.entities;
package com.presight.ai.consumer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class Call {//extends BaseEntity {

    /**
     * 	The only supported generated ID field on classes annotated with @RelationshipProperties is @GeneratedValue with using the default ID generator InternalIdGenerator as shown above. Other generators will lead to a failure during startup..
     */
    @Id
    @GeneratedValue
//    @Setter(AccessLevel.NONE)
    private Long id;

    private String fromPhoneNum;
    private String toPhoneNum;
    private LocalDateTime calTime;
    private Duration callDuration;
    private RegineTypeEnum regineFrom;
    private RegineTypeEnum regineTo;

    @TargetNode
    private Phone phone;

    //    private String provider; // TODO?

}

