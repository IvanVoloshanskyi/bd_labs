package iot.lviv.controller;


import iot.lviv.domain.IntervalOfUpdatesEntity;
import iot.lviv.dto.IntervalOfUpdatesDTO;
import iot.lviv.dto.assembler.IntervalOfUpdatesDTOAssembler;
import iot.lviv.service.IntervalOfUpdatesService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/intervalOfUpdates")
public class IntervalOfUpdatesController {
    private final IntervalOfUpdatesService intervalOfUpdatesService;
    private final IntervalOfUpdatesDTOAssembler intervalOfUpdatesDTOAssembler;

    public IntervalOfUpdatesController(IntervalOfUpdatesService intervalOfUpdatesService, IntervalOfUpdatesDTOAssembler intervalOfUpdatesDTOAssembler) {
        this.intervalOfUpdatesService = intervalOfUpdatesService;
        this.intervalOfUpdatesDTOAssembler = intervalOfUpdatesDTOAssembler;
    }

    @GetMapping(value = "/{intervalOfUpdatesId}")
    public ResponseEntity<IntervalOfUpdatesDTO> getIntervalOfUpdates(@PathVariable Integer intervalOfUpdatesId) {
        IntervalOfUpdatesEntity intervalOfUpdatesEntity = intervalOfUpdatesService.findById(intervalOfUpdatesId);
        IntervalOfUpdatesDTO intervalOfUpdatesDTO = intervalOfUpdatesDTOAssembler.toModel(intervalOfUpdatesEntity);
        return new ResponseEntity<>(intervalOfUpdatesDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<IntervalOfUpdatesDTO>> getAllIntervalOfUpdates() {
        List<IntervalOfUpdatesEntity> entityList = intervalOfUpdatesService.findAll();
        CollectionModel<IntervalOfUpdatesDTO> dtos = intervalOfUpdatesDTOAssembler.toCollectionModel(entityList);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IntervalOfUpdatesDTO> addIntervalOfUpdates(@RequestBody IntervalOfUpdatesEntity entity) {
        try{
            IntervalOfUpdatesEntity newEntity = intervalOfUpdatesService.create(entity);
            IntervalOfUpdatesDTO dto = intervalOfUpdatesDTOAssembler.toModel(newEntity);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }catch (Exception e){
            return null;
        }

    }

    @PutMapping(value = "/{intervalOfUpdatesId}")
    public ResponseEntity<?> updateIntervalOfUpdates(@RequestBody IntervalOfUpdatesEntity intervalOfUpdatesEntity, @PathVariable Integer intervalOfUpdatesId) {
        intervalOfUpdatesService.update(intervalOfUpdatesId, intervalOfUpdatesEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{intervalOfUpdatesId}")
    public ResponseEntity<?> deleteIntervalOfUpdates(@PathVariable Integer intervalOfUpdatesId) {
        intervalOfUpdatesService.delete(intervalOfUpdatesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}