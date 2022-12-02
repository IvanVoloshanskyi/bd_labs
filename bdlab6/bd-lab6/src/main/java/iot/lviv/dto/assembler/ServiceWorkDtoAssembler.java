package iot.lviv.dto.assembler;

import iot.lviv.controller.ServiceWorkController;
import iot.lviv.domain.ServiceWorkEntity;
import iot.lviv.dto.ServiceWorkDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ServiceWorkDtoAssembler implements RepresentationModelAssembler<ServiceWorkEntity, ServiceWorkDTO> {
    @Override
    public ServiceWorkDTO toModel(ServiceWorkEntity entity) {
        ServiceWorkDTO serviceWorkDTO = ServiceWorkDTO.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .description(entity.getDescription())
                .build();
        Link selfLink = linkTo(methodOn(ServiceWorkController.class).getServiceWork(serviceWorkDTO.getId())).withSelfRel();
        serviceWorkDTO.add(selfLink);
        return serviceWorkDTO;
    }

    @Override
    public CollectionModel<ServiceWorkDTO> toCollectionModel(Iterable<? extends ServiceWorkEntity> entities) {
        CollectionModel<ServiceWorkDTO> serviceWorkDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ServiceWorkController.class).getAllServiceWork()).withSelfRel();
        serviceWorkDTOS.add(selfLink);
        return serviceWorkDTOS;
    }
}