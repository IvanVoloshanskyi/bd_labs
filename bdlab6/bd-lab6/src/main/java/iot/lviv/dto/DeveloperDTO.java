package iot.lviv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "developer", collectionRelation = "developers")
public class DeveloperDTO extends RepresentationModel<DeveloperDTO> {
    private Integer id;
    private String name;
    private String surname;
    private String telephone_num;


}
