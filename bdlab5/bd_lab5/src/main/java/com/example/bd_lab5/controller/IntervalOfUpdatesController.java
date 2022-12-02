package com.example.bd_lab5.controller;

import com.example.bd_lab5.DTO.GpsDTO;
import com.example.bd_lab5.DTO.IntervalOfUpdatesDTO;
import com.example.bd_lab5.domain.Gps;
import com.example.bd_lab5.domain.IntervalOfUpdates;
import com.example.bd_lab5.mapper.GpsMapper;
import com.example.bd_lab5.mapper.IntervalOfUpdatesMapper;
import com.example.bd_lab5.service.GpsService;
import com.example.bd_lab5.service.IntervalOfUpdatesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/intervalOfUpdates")
public class IntervalOfUpdatesController {
    private final IntervalOfUpdatesService intervalOfUpdatesService;

    @GetMapping
    public List<IntervalOfUpdatesDTO> getAllIntervalOfUpdates() {
        return intervalOfUpdatesService.getAllIntervalOfUpdates().stream().map(IntervalOfUpdatesMapper::mapIntervalOfUpdatesToDTO).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<IntervalOfUpdatesDTO> getIntervalOfUpdatesById(@PathVariable("id") Integer id) {
        IntervalOfUpdates intervalOfUpdates = intervalOfUpdatesService.getIntervalOfUpdatesById(id);
        if (intervalOfUpdates == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                IntervalOfUpdatesMapper.mapIntervalOfUpdatesToDTO(intervalOfUpdates), HttpStatus.OK);
    }

    @PostMapping
    public IntervalOfUpdatesDTO createIntervalOfUpdates(@RequestBody IntervalOfUpdatesDTO intervalOfUpdatesDTO) {
        return IntervalOfUpdatesMapper.mapIntervalOfUpdatesToDTO(intervalOfUpdatesService.createIntervalOfUpdates(intervalOfUpdatesDTO));
    }

    @PutMapping
    public ResponseEntity<IntervalOfUpdatesDTO> updateIntervalOfUpdates(@RequestBody IntervalOfUpdatesDTO intervalOfUpdatesDTO) {
        IntervalOfUpdates intervalOfUpdates = intervalOfUpdatesService.getIntervalOfUpdatesById(intervalOfUpdatesDTO.getId());
        if (intervalOfUpdates == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                IntervalOfUpdatesMapper.mapIntervalOfUpdatesToDTO(intervalOfUpdatesService.updateIntervalOfUpdates(intervalOfUpdatesDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<IntervalOfUpdatesDTO> deleteIntervalOfUpdates(@PathVariable("id") Integer id) {
        IntervalOfUpdates intervalOfUpdates = intervalOfUpdatesService.getIntervalOfUpdatesById(id);
        if (intervalOfUpdates == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                IntervalOfUpdatesMapper.mapIntervalOfUpdatesToDTO(intervalOfUpdatesService.deleteIntervalOfUpdatesById(id)), HttpStatus.OK
        );
    }

}