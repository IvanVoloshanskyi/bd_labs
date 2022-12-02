package iot.lviv.controller;


import iot.lviv.domain.GpsEntity;
import iot.lviv.dto.GpsDTO;
import iot.lviv.dto.assembler.GpsDtoAssembler;
import iot.lviv.service.GpsService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/gps")
public class GpsController {
    private final GpsService gpsService;
    private final GpsDtoAssembler gpsDtoAssembler;

    public GpsController(GpsService gpsService, GpsDtoAssembler gpsDtoAssembler) {
        this.gpsService = gpsService;
        this.gpsDtoAssembler = gpsDtoAssembler;
    }

    @GetMapping(value = "/{gpsId}")
    public ResponseEntity<GpsDTO> getGps(@PathVariable Integer gpsId) {
        GpsEntity orderEntity = gpsService.findById(gpsId);
        GpsDTO orderDto = gpsDtoAssembler.toModel(orderEntity);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<GpsDTO>> getAllGps() {
        List<GpsEntity> orderEntityList = gpsService.findAll();
        CollectionModel<GpsDTO> orderDtos = gpsDtoAssembler.toCollectionModel(orderEntityList);
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GpsDTO> addGps(@RequestBody GpsEntity gpsEntity) {
        GpsEntity newOrderEntity = gpsService.create(gpsEntity);
        GpsDTO orderDto = gpsDtoAssembler.toModel(newOrderEntity);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{gpsId}")
    public ResponseEntity<?> updateGps(@RequestBody GpsEntity gpsEntity, @PathVariable Integer gpsId) {
        gpsService.update(gpsId, gpsEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{gpsId}")
    public ResponseEntity<?> deleteGps(@PathVariable Integer gpsId) {
        gpsService.delete(gpsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}