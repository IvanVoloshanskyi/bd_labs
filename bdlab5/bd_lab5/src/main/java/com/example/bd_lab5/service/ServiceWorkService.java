package com.example.bd_lab5.service;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "service_work", schema = "mydb")
public class ServiceWorkService {
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
