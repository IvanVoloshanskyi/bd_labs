package com.example.bd_lab5.DTO;
import lombok.*;

import org.springframework.hateoas.server.core.Relation;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdressDTO{
    private Integer id;
    private String adress;
    private String street;
    private String build;


}

