package com.example.bd_lab5.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "meteostation", schema = "mydb")
public class Meteostation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "installation_date")
    private Date installationDate;
    @Basic
    @Column(name = "data_id")
    private Integer dataId;
    @Basic
    @Column(name = "interval_of_updates_id")
    private Integer intervalOfUpdatesId;
    @Basic
    @Column(name = "location_id")
    private Integer locationId;
    @Basic
    @Column(name = "service_work_id")
    private Integer serviceWorkId;
    @Basic
    @Column(name = "developer_id")
    private Integer developerId;


}
