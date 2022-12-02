package iot.lviv.dto.assembler;

import iot.lviv.controller.AdressController;
import iot.lviv.domain.AdressEntity;
import iot.lviv.dto.AdressDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class AdressDtoAssembler implements RepresentationModelAssembler<AdressEntity, AdressDTO> {
    @Override
    public AdressDTO toModel(AdressEntity entity) {
        AdressDTO adressDTO = AdressDTO.builder()
                .id(entity.getId())
                .adress(entity.getAdress())
                .street(entity.getStreet())
                .build(entity.getBuild())
                .build();
        Link selfLink = linkTo(methodOn(AdressController.class).getAdress(adressDTO.getId())).withSelfRel();
        adressDTO.add(selfLink);
        adressDTO.add(linkTo(methodOn(AdressController.class).getAdress(adressDTO.getId())).withSelfRel());
        return adressDTO;
    }

    @Override
    public CollectionModel<AdressDTO> toCollectionModel(Iterable<? extends AdressEntity> entities) {
        CollectionModel<AdressDTO> adressDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AdressController.class).getAllAdress()).withSelfRel();
        adressDTOS.add(selfLink);
        return adressDTOS;
    }
}