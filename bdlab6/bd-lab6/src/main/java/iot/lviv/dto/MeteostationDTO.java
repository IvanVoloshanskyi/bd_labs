package iot.lviv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "meteostation", collectionRelation = "meteostations")
public class MeteostationDTO extends RepresentationModel<MeteostationDTO> {
    private Integer id;
    private Date installation_date;
    private Integer data_id;
    private Integer interval_of_updates_id;
    private Integer location_id;
    private Integer service_work_id;
    private Integer developer_id;


}
