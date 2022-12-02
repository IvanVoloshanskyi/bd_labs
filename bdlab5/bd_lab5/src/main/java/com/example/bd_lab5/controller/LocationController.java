package com.example.bd_lab5.controller;

import com.example.bd_lab5.DTO.IntervalOfUpdatesDTO;
import com.example.bd_lab5.DTO.LocationDTO;
import com.example.bd_lab5.domain.IntervalOfUpdates;
import com.example.bd_lab5.domain.Location;
import com.example.bd_lab5.mapper.IntervalOfUpdatesMapper;
import com.example.bd_lab5.mapper.LocationMapper;
import com.example.bd_lab5.service.IntervalOfUpdatesService;
import com.example.bd_lab5.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/location")
public class LocationController {
    private final LocationService locationService;


    @GetMapping
    public List<LocationDTO> getAllLocation() {
        return locationService.getAllLocation().stream().map(LocationMapper::mapLocationToDTO).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable("id") Integer id) {
        Location location = locationService.getLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                LocationMapper.mapLocationToDTO(location), HttpStatus.OK);
    }

    @PostMapping
    public LocationDTO createLocation(@RequestBody LocationDTO locationDTO) {
        return LocationMapper.mapLocationToDTO(locationService.createLocation(locationDTO));
    }

    @PutMapping
    public ResponseEntity<LocationDTO> updateLocation(@RequestBody LocationDTO locationDTO) {
        Location location = locationService.getLocationById(locationDTO.getId());
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                LocationMapper.mapLocationToDTO(locationService.updateLocation(locationDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocationDTO> deleteLocation(@PathVariable("id") Integer id) {
        Location location = locationService.getLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                LocationMapper.mapLocationToDTO(locationService.deleteLocation(id)), HttpStatus.OK
        );
    }
}


//    @GetMapping(value = "/location/{gps}")
//    public ResponseEntity<CollectionModel<LocationDTO>> getLocationByAuthor(@PathVariable Integer gps) {
//        List<Location> locations = locationService.getLocationByGpsId(gps);
//        CollectionModel<LocationDTO> locationDTOS = locationMapper.mapLocationToDTO(locations);
//        return new ResponseEntity<>(locationDTOS, HttpStatus.OK);
//    }
//}