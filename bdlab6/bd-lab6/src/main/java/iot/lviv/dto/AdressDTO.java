package iot.lviv.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;


@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "adress", collectionRelation = "adresses")
public class AdressDTO extends RepresentationModel<AdressDTO> {
    private Integer id;
    private String adress;
    private String street;
    private String build;


}

