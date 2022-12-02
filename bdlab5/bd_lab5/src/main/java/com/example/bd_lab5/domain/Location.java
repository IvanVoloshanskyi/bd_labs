package com.example.bd_lab5.domain;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@AllArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "location", schema = "mydb")
public class Location {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "adress_id")
    private Integer adressId;
    @Basic
    @Column(name = "gps_id")
    private Integer gpsId;


}
