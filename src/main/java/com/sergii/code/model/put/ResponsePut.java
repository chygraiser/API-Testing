package com.sergii.code.model.put;

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

    }
