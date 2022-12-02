package com.example.bd_lab5.domain;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "developer", schema = "mydb")
public class Developer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "telephone_num")
    private String telephoneNum;


}
