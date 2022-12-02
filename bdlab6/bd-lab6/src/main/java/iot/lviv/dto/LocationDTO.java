package iot.lviv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "location", collectionRelation = "locations")
public class LocationDTO extends RepresentationModel<LocationDTO> {
    private Integer id;
    private String city;
    private Integer adress_id;
    private Integer gps_id;


}
