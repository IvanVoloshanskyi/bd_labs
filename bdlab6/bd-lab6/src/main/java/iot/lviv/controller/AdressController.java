package iot.lviv.controller;


import iot.lviv.domain.AdressEntity;
import iot.lviv.dto.AdressDTO;
import iot.lviv.dto.assembler.AdressDtoAssembler;
import iot.lviv.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/cities")
public class AdressController {
    @Autowired
    private final AdressService adressService;
    @Autowired
    private final AdressDtoAssembler adressDtoAssembler;

    public AdressController(AdressService adressService, AdressDtoAssembler adressDtoAssembler) {
        this.adressService = adressService;
        this.adressDtoAssembler = adressDtoAssembler;
    }

    @GetMapping(value = "/{adressId}")
    public ResponseEntity<AdressDTO> getAdress(@PathVariable Integer adressId) {
        AdressEntity adressEntity = adressService.findById(adressId);
        AdressDTO adressDTO = adressDtoAssembler.toModel(adressEntity);
        return new ResponseEntity<>(adressDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<AdressDTO>> getAllAdress() {
        List<AdressEntity> entityList = adressService.findAll();
        CollectionModel<AdressDTO> dtos = adressDtoAssembler.toCollectionModel(entityList);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdressDTO> addAdress(@RequestBody AdressEntity entity) {
        try{
            AdressEntity newEntity = adressService.create(entity);
            AdressDTO dto = adressDtoAssembler.toModel(newEntity);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
        catch(Exception e){
            return null;
        }

    }

    @PutMapping(value = "/{adressId}")
    public ResponseEntity<?> updateAdress(@RequestBody AdressEntity entity, @PathVariable Integer adressId) {
        try {
            adressService.update(adressId, entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return null;
        }
    }

    @DeleteMapping(value = "/{adressId}")
    public ResponseEntity<?> deleteCity(@PathVariable Integer cityId) {
        try {
            adressService.delete(cityId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return null;
        }
    }

    @PostMapping(value = "/procedure_inserts")
    public ResponseEntity<?> insertTenAdress() {
        adressService.insertTenAdress("NONE", "NONE", "NONE");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}