package iot.lviv.dto.assembler;


import iot.lviv.controller.AdressController;
import iot.lviv.controller.GpsController;
import iot.lviv.controller.LocationController;
import iot.lviv.domain.LocationEntity;
import iot.lviv.dto.LocationDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LocationDtoAssembler implements RepresentationModelAssembler<LocationEntity, LocationDTO> {
    @Override
    public LocationDTO toModel(LocationEntity entity) {
        LocationDTO locationDTO = LocationDTO.builder()
                .id(entity.getId())
                .city(entity.getCity())
                .adress_id(entity.getAdress().getId())
                .gps_id(entity.getGps().getId())
                .build();
        locationDTO.add(linkTo(methodOn(LocationController.class).getLocation(locationDTO.getId())).withSelfRel(),
                linkTo(methodOn(AdressController.class).getAdress(entity.getAdress().getId())).withRel("adress"),
                linkTo(methodOn(GpsController.class).getGps(entity.getGps().getId())).withRel("gps")
        );
        return locationDTO;
    }

    @Override
    public CollectionModel<LocationDTO> toCollectionModel(Iterable<? extends LocationEntity> entities) {
        CollectionModel<LocationDTO> locationDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(LocationController.class).getAllLocations()).withSelfRel();
        locationDTOS.add(selfLink);
        return locationDTOS;
    }
}