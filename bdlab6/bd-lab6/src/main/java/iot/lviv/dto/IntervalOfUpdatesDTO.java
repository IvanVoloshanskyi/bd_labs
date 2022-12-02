package iot.lviv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "invervalOfUpdate", collectionRelation = "invervalOfUpdates")
public class IntervalOfUpdatesDTO extends RepresentationModel<IntervalOfUpdatesDTO> {
    private Integer id;
    private Integer interval;



}
