package com.example.bd_lab5.domain;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "data", schema = "mydb")
public class Data {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "temperature")
    private Integer temperature;
    @Basic
    @Column(name = "humidity")
    private Integer humidity;
    @Basic
    @Column(name = "wind_speed")
    private Integer windSpeed;
    @Basic
    @Column(name = "atmospheric_pressure")
    private Integer atmosphericPressure;
    @Basic
    @Column(name = "wind_direction")
    private String windDirection;
    @Basic
    @Column(name = "interval_of_updates_id")
    private Integer intervalOfUpdatesId;

}
