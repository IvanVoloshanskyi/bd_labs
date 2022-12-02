package com.example.bd_lab5.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class DataDTO {
    private Integer id;
    private Integer temperature;
    private Integer humidity;
    private Integer wind_speed;
    private Integer atmospheric_pressure;
    private String wind_direction;
    private Integer interval_of_updates_id;


}
