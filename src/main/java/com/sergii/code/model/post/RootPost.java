package com.sergii.code.model.post;

import com.sergii.code.model.get.Root;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class RootPost {

    private String name;
    private String job;
    private Integer id;
    private String createdAt;

}
