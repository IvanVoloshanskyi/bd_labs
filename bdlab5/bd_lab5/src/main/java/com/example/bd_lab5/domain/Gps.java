package com.example.bd_lab5.domain;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "gps", schema = "mydb")
public class Gps {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "latitude")
    private String latitude;
    @Basic
    @Column(name = "longtitude")
    private String longtitude;

}
