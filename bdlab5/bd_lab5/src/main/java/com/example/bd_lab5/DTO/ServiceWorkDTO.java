package com.example.bd_lab5.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class ServiceWorkDTO {
    private Integer id;
    private Date date;
    private String description;
}
