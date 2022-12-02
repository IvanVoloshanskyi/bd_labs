package iot.lviv.controller;


import iot.lviv.domain.MeteostationEntity;
import iot.lviv.dto.MeteostationDTO;
import iot.lviv.dto.assembler.MeteostationDtoAssembler;
import iot.lviv.service.MeteostationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/meteostation")
public class MeteostationController {
    private final MeteostationService meteostationService;
    private final MeteostationDtoAssembler meteostationDtoAssembler;

    public MeteostationController(MeteostationService meteostationService, MeteostationDtoAssembler meteostationDtoAssembler) {
        this.meteostationService = meteostationService;
        this.meteostationDtoAssembler = meteostationDtoAssembler;
    }

    @GetMapping(value = "/{meteostationId}")
    public ResponseEntity<MeteostationDTO> getMeteostation(@PathVariable Integer meteostationId) {
        MeteostationEntity meteostationEntity = meteostationService.findById(meteostationId);
        MeteostationDTO meteostationDTO = meteostationDtoAssembler.toModel(meteostationEntity);
        return new ResponseEntity<>(meteostationDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<MeteostationDTO>> getAllMeteostations() {
        List<MeteostationEntity> entityList = meteostationService.findAll();
        CollectionModel<MeteostationDTO> dtos = meteostationDtoAssembler.toCollectionModel(entityList);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MeteostationDTO> addMeteostation(@RequestBody MeteostationEntity entity) {
        MeteostationEntity newEntity = meteostationService.create(entity);
        MeteostationDTO dto = meteostationDtoAssembler.toModel(newEntity);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{meteostationId}")
    public ResponseEntity<?> updatePizzaSize(@RequestBody MeteostationEntity entity, @PathVariable Integer meteostationId) {
        meteostationService.update(meteostationId, entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{meteostationSizeId}")
    public ResponseEntity<?> deleteMeteostation(@PathVariable Integer meteostationSizeId) {
        meteostationService.delete(meteostationSizeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}