package com.example.bd_lab5.domain;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adress", schema = "mydb")
public class Adress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "adress")
    private String adress;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "build")
    private String build;

}
