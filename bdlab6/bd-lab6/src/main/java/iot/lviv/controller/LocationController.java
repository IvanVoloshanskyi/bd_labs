package iot.lviv.controller;


import iot.lviv.domain.LocationEntity;
import iot.lviv.dto.LocationDTO;
import iot.lviv.dto.assembler.LocationDtoAssembler;
import iot.lviv.service.LocationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/location")
public class LocationController {
    private final LocationService locationService;
    private final LocationDtoAssembler locationDtoAssembler;


    public LocationController(LocationService locationService, LocationDtoAssembler locationDtoAssembler) {
        this.locationService = locationService;
        this.locationDtoAssembler = locationDtoAssembler;
    }

    @GetMapping(value = "/{locationId}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable Integer locationId) {
        LocationEntity locationEntity = locationService.findById(locationId);
        LocationDTO locationDTO = locationDtoAssembler.toModel(locationEntity);
        return new ResponseEntity<>(locationDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<LocationDTO>> getAllLocations() {
        List<LocationEntity> locationEntityList = locationService.findAll();
        CollectionModel<LocationDTO> locationDTOS = locationDtoAssembler.toCollectionModel(locationEntityList);
        return new ResponseEntity<>(locationDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationDTO> addLocation(@RequestBody LocationEntity locationEntity) {
        LocationEntity newLocationEntity = locationService.create(locationEntity);
        LocationDTO locationDTO = locationDtoAssembler.toModel(newLocationEntity);
        return new ResponseEntity<>(locationDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{locationId}")
    public ResponseEntity<?> updateLocation(@RequestBody LocationEntity locationEntity, @PathVariable Integer locationId) {
        locationService.update(locationId, locationEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{locationId}")
    public ResponseEntity<?> deleteLocation(@PathVariable Integer locationId) {
        locationService.delete(locationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/withAdressId/{vehicleTypeId}")
    public ResponseEntity<CollectionModel<LocationDTO>> getAllWithAdressId(@PathVariable Integer adressId) {
        List<LocationEntity> entityList = locationService.getLocationEntityByAdress(adressId);
        CollectionModel<LocationDTO> dtos = locationDtoAssembler.toCollectionModel(entityList);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}