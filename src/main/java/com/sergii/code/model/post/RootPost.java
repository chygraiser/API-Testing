package com.sergii.code.model.post;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.security.SecureRandom;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class RootPost {


    private String name = "Test";
    private String job = "AQA";
    private String id;
    private String createdAt;

    @JsonSetter(value = "createdAt")
    public void setCreateAt(String newCreatedAt){
        this.createdAt = "2023-12-17T10:37:05.070Z";
    }
    @JsonSetter (value = "id")
    public void setId (String newId){
        this.id = "2";
    }

}
