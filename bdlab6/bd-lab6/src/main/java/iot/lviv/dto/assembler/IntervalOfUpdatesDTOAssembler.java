package iot.lviv.dto.assembler;


import iot.lviv.controller.IntervalOfUpdatesController;
import iot.lviv.domain.IntervalOfUpdatesEntity;
import iot.lviv.dto.IntervalOfUpdatesDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class IntervalOfUpdatesDTOAssembler implements RepresentationModelAssembler<IntervalOfUpdatesEntity, IntervalOfUpdatesDTO> {
    @Override
    public IntervalOfUpdatesDTO toModel(IntervalOfUpdatesEntity entity) {
        IntervalOfUpdatesDTO intervalsDTO = IntervalOfUpdatesDTO.builder()
                .id(entity.getId())
                .interval(entity.getInterval())
                .build();
        Link selfLink = linkTo(methodOn(IntervalOfUpdatesController.class).getIntervalOfUpdates(intervalsDTO.getId())).withSelfRel();
        intervalsDTO.add(selfLink);
        return intervalsDTO;
    }

    @Override
    public CollectionModel<IntervalOfUpdatesDTO> toCollectionModel(Iterable<? extends IntervalOfUpdatesEntity> entities) {
        CollectionModel<IntervalOfUpdatesDTO> intervalsDTO = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(IntervalOfUpdatesController.class).getAllIntervalOfUpdates()).withSelfRel();
        intervalsDTO.add(selfLink);
        return intervalsDTO;
    }
}