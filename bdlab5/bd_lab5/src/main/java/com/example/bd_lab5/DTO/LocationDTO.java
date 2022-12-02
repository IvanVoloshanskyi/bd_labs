package com.example.bd_lab5.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class LocationDTO {
    private Integer id;
    private String city;
    private Integer adress_id;
    private Integer gps_id;


}
