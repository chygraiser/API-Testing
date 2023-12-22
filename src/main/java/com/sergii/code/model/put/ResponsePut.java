package com.sergii.code.model.put;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ResponsePut {

    private String name;
    private String job;
    private String updatedAt;

    @JsonSetter(value = "updatedAt")
    public void setUpdateAt(String newUpdatedAt){
        this.updatedAt = "2023-12-17T12:14:01.616Z";
    }

    }
