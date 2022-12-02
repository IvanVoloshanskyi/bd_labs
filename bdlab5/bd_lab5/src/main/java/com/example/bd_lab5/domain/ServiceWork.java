package com.example.bd_lab5.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "service_work", schema = "mydb")
public class ServiceWork {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "description")
    private String description;


}
