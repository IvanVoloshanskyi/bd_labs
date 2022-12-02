package iot.lviv.dto.assembler;


import iot.lviv.controller.DeveloperController;
import iot.lviv.domain.DeveloperEntity;
import iot.lviv.dto.DeveloperDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
@Component
public class DeveloperDtoAssembler implements RepresentationModelAssembler<DeveloperEntity, DeveloperDTO> {
    @Override
    public DeveloperDTO toModel(DeveloperEntity entity) {
        DeveloperDTO developerDTO = DeveloperDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .telephone_num(entity.getTelephoneNum())
                .build();
        developerDTO.add(linkTo(methodOn(DeveloperController.class).getDeveloper(developerDTO.getId())).withSelfRel()
        );
        return developerDTO;
    }

    @Override
    public CollectionModel<DeveloperDTO> toCollectionModel(Iterable<? extends DeveloperEntity> entities) {
        CollectionModel<DeveloperDTO> developerDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DeveloperController.class).getAllDevelopers()).withSelfRel();
        developerDTOS.add(selfLink);
        return developerDTOS;
    }
}