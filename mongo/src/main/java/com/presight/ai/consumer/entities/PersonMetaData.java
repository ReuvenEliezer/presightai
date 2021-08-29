package com.presight.ai.consumer.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonMetaData implements Serializable {
    private ColorEnum eyeColor;
    private ColorEnum hairColor;
    private double height;

}
