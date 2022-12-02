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
@Relation(itemRelation = "serviceWork", collectionRelation = "serviceWorks")
public class ServiceWorkDTO extends RepresentationModel<ServiceWorkDTO> {
    private Integer id;
    private Date date;
    private String description;
}
