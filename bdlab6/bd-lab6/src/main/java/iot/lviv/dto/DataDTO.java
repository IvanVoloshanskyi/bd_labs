package iot.lviv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "data", collectionRelation = "data")
public class DataDTO extends RepresentationModel<DataDTO> {
    private Integer id;
    private Integer temperature;
    private Integer humidity;
    private Integer wind_speed;
    private Integer atmospheric_pressure;
    private String wind_direction;
    private Integer interval_of_updates_id;


}
