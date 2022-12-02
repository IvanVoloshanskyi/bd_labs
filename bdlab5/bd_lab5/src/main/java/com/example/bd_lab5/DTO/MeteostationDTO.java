package com.example.bd_lab5.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class MeteostationDTO {
    private Integer id;
    private Date installation_date;
    private Integer data_id;
    private Integer interval_of_updates_id;
    private Integer location_id;
    private Integer service_work_id;
    private Integer developer_id;


}
