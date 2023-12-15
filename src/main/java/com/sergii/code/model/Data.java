package com.sergii.code.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Data {

    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;

}
