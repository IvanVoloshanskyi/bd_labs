package com.example.bd_lab5.domain;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "interval_of_updates", schema = "mydb")
public class IntervalOfUpdates {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "interval_updates")
    private Integer interval;


}
