package iot.lviv.dto.assembler;

import iot.lviv.controller.GpsController;
import iot.lviv.domain.GpsEntity;
import iot.lviv.dto.GpsDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GpsDtoAssembler implements RepresentationModelAssembler<GpsEntity, GpsDTO> {
    @Override
    public GpsDTO toModel(GpsEntity entity) {
        GpsDTO gpsDTO = GpsDTO.builder()
                .id(entity.getId())
                .latitude(entity.getLatitude())
                .longtitude(entity.getLongtitude())
                .build();
        gpsDTO.add(linkTo(methodOn(GpsController.class).getGps(gpsDTO.getId())).withSelfRel()
        );
        return gpsDTO;
    }

    @Override
    public CollectionModel<GpsDTO> toCollectionModel(Iterable<? extends GpsEntity> entities) {
        CollectionModel<GpsDTO> gpsDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(GpsController.class).getAllGps()).withSelfRel();
        gpsDTOS.add(selfLink);
        return gpsDTOS;
    }
}