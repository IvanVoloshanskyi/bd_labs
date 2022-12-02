package iot.lviv.dto.assembler;


import iot.lviv.controller.*;
import iot.lviv.domain.MeteostationEntity;
import iot.lviv.dto.MeteostationDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MeteostationDtoAssembler implements RepresentationModelAssembler<MeteostationEntity, MeteostationDTO> {
    @Override
    public MeteostationDTO toModel(MeteostationEntity entity) {
        MeteostationDTO meteostationDTO = MeteostationDTO.builder()
                .id(entity.getId())
                .installation_date(entity.getInstallationDate())
                .data_id(entity.getData().getId())
                .interval_of_updates_id(entity.getIntervalOfUpdates().getId())
                .location_id(entity.getLocation().getId())
                .service_work_id(entity.getServiceWork().getId())
                .developer_id(entity.getDeveloper().getId())
                .build();
        meteostationDTO.add(linkTo(methodOn(MeteostationController.class).getMeteostation(meteostationDTO.getId())).withSelfRel(),
                linkTo(methodOn(DataController.class).getData(entity.getData().getId())).withRel("Data"),
                linkTo(methodOn(IntervalOfUpdatesController.class).getIntervalOfUpdates(entity.getIntervalOfUpdates().getId())).withRel("IntervalOfUpdates"),
                linkTo(methodOn(LocationController.class).getLocation(entity.getLocation().getId())).withRel("Location"),
                linkTo(methodOn(ServiceWorkController.class).getServiceWork(entity.getServiceWork().getId())).withRel("ServiceWork"),
                linkTo(methodOn(DeveloperController.class).getDeveloper(entity.getDeveloper().getId())).withRel("Developer")
        );

        return meteostationDTO;
    }

    @Override
    public CollectionModel<MeteostationDTO> toCollectionModel(Iterable<? extends MeteostationEntity> entities) {
        CollectionModel<MeteostationDTO> meteostationDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(MeteostationController.class).getAllMeteostations()).withSelfRel();
        meteostationDTOS.add(selfLink);
        return meteostationDTOS;
    }
}