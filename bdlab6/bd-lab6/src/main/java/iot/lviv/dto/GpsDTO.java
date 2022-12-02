package iot.lviv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "gps", collectionRelation = "gps")
public class GpsDTO extends RepresentationModel<GpsDTO> {
    private Integer id;
    private String latitude;
    private String longtitude;

}
