package com.presight.ai.consumer.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "stock")
public class Stock implements Serializable {

    private String gics_sector;
    private String volume_avg;

}
