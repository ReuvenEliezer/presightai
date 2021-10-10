package com.presight.ai.consumer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@Document(collection = "person")
public class Person implements Serializable {

    @Id
    private Long id;

    @JsonSetter("first_name")
    @Indexed//(unique = true) //TODO delete
    private String firstName;

    @JsonSetter("last_name")
    private String lastName;

    @JsonSetter("phone_list")
    @Indexed(unique = true) //TODO un-mark comment
    private Set<String> phoneList;

    private GenderTypeEnum gender;

    @JsonSetter("is_citizen")
    private boolean isCitizen;

    @JsonSetter("person_meta_data")
    private PersonMetaData personMetaData;

    public void setPhoneList(Set<String> phoneList) {
        //TODO fix
        this.phoneList = Stream.of(phoneList.toString()
                        .replace("[", "").replace("]", " ")
                        .split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
