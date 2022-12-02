package iot.lviv.controller;


import iot.lviv.domain.ServiceWorkEntity;
import iot.lviv.dto.ServiceWorkDTO;
import iot.lviv.dto.assembler.ServiceWorkDtoAssembler;
import iot.lviv.service.ServiceWorkService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/serviseWorks")
public class ServiceWorkController {
    private final ServiceWorkService serviceWorkService;
    private final ServiceWorkDtoAssembler serviceWorkDtoAssembler;

    public ServiceWorkController(ServiceWorkService serviceWorkService, ServiceWorkDtoAssembler serviceWorkDtoAssembler) {
        this.serviceWorkService = serviceWorkService;
        this.serviceWorkDtoAssembler = serviceWorkDtoAssembler;
    }

    @GetMapping(value = "/{serviseWorkId}")
    public ResponseEntity<ServiceWorkDTO> getServiceWork(@PathVariable Integer serviseWorkId) {
        ServiceWorkEntity serviceWorkEntity = serviceWorkService.findById(serviseWorkId);
        ServiceWorkDTO serviceWorkDTO = serviceWorkDtoAssembler.toModel(serviceWorkEntity);
        return new ResponseEntity<>(serviceWorkDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ServiceWorkDTO>> getAllServiceWork() {
        List<ServiceWorkEntity> entityList = serviceWorkService.findAll();
        CollectionModel<ServiceWorkDTO> dtos = serviceWorkDtoAssembler.toCollectionModel(entityList);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceWorkDTO> addServiceWork(@RequestBody ServiceWorkEntity entity) {
        ServiceWorkEntity newEntity = serviceWorkService.create(entity);
        ServiceWorkDTO dto = serviceWorkDtoAssembler.toModel(newEntity);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{serviceWorkId}")
    public ResponseEntity<?> updateServiceWork(@RequestBody ServiceWorkEntity entity, @PathVariable Integer serviceWorkId) {
        serviceWorkService.update(serviceWorkId, entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{serviceWorkId}")
    public ResponseEntity<?> deleteServiceWork(@PathVariable Integer serviceWorkId) {
        serviceWorkService.delete(serviceWorkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}