package com.example.bd_lab5.controller;

import com.example.bd_lab5.DTO.DeveloperDTO;
import com.example.bd_lab5.DTO.GpsDTO;
import com.example.bd_lab5.domain.Developer;
import com.example.bd_lab5.domain.Gps;
import com.example.bd_lab5.mapper.DeveloperMapper;
import com.example.bd_lab5.mapper.GpsMapper;
import com.example.bd_lab5.service.DeveloperService;
import com.example.bd_lab5.service.GpsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/gps")
public class GpsController {
    private final GpsService gpsService;

    @GetMapping
    public List<GpsDTO> getAllGps() {
        return gpsService.getAllGps().stream().map(GpsMapper::mapGpsToDTO).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<GpsDTO> getGpsById(@PathVariable("id") Integer id) {
        Gps gps = gpsService.getGpsById(id);
        if (gps == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                GpsMapper.mapGpsToDTO(gps), HttpStatus.OK);
    }

    @PostMapping
    public GpsDTO createGps(@RequestBody GpsDTO gpsDTO) {
        return GpsMapper.mapGpsToDTO(gpsService.createGps(gpsDTO));
    }

    @PutMapping
    public ResponseEntity<GpsDTO> updateGps(@RequestBody GpsDTO gpsDTO) {
        Gps gps = gpsService.getGpsById(gpsDTO.getId());
        if (gps == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                GpsMapper.mapGpsToDTO(gpsService.updateGps(gpsDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GpsDTO> deleteGps(@PathVariable("id") Integer id) {
        Gps gps = gpsService.getGpsById(id);
        if (gps == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                GpsMapper.mapGpsToDTO(gpsService.deleteGpsById(id)), HttpStatus.OK
        );
    }

}