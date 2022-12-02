package com.example.bd_lab5.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class GpsDTO {
    private Integer id;
    private String latitude;
    private String longtitude;

}
