package com.presight.ai.consumer.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonMetaData implements Serializable {
    private ColorEnum eyeColor;
    private ColorEnum hairColor;
    private double height;

}
