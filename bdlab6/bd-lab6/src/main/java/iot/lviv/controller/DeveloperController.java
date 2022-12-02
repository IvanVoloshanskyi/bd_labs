package iot.lviv.controller;


import iot.lviv.domain.DeveloperEntity;
import iot.lviv.dto.DeveloperDTO;
import iot.lviv.dto.assembler.DeveloperDtoAssembler;
import iot.lviv.service.DeveloperService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/developers")
public class DeveloperController {
    private final DeveloperService developerService;
    private final DeveloperDtoAssembler developerDtoAssembler;

    public DeveloperController(DeveloperService developerService, DeveloperDtoAssembler developerDtoAssembler) {
        this.developerService = developerService;
        this.developerDtoAssembler = developerDtoAssembler;
    }

    @GetMapping(value = "/{developerId}")
    public ResponseEntity<DeveloperDTO> getDeveloper(@PathVariable Integer developerId) {
        DeveloperEntity deliveryEntity = developerService.findById(developerId);
        DeveloperDTO developerDTO = developerDtoAssembler.toModel(deliveryEntity);
        return new ResponseEntity<>(developerDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<DeveloperDTO>> getAllDevelopers() {
        List<DeveloperEntity> entityList = developerService.findAll();
        CollectionModel<DeveloperDTO> dtos = developerDtoAssembler.toCollectionModel(entityList);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> addDeveloper(@RequestBody DeveloperEntity entity) {
        DeveloperEntity newEntity = developerService.create(entity);
        DeveloperDTO dto = developerDtoAssembler.toModel(newEntity);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{developerId}")
    public ResponseEntity<?> updateDelivery(@RequestBody DeveloperEntity entity, @PathVariable Integer developerId) {
        developerService.update(developerId, entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{developerId}")
    public ResponseEntity<?> deleteDeveloper(@PathVariable Integer developerId) {
        developerService.delete(developerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/cursor")
    public ResponseEntity<?> createTablesWithCursor() {
        developerService.createTablesWithCursor();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}