package iot.lviv.controller;


import iot.lviv.domain.DataEntity;
import iot.lviv.dto.DataDTO;
import iot.lviv.dto.assembler.DataDtoAssembler;
import iot.lviv.service.DataService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "api/data")
public class DataController {
    private final DataService dataService;
    private final DataDtoAssembler dataDtoAssembler;

    public DataController(DataService dataService, DataDtoAssembler dataDtoAssembler) {
        this.dataService = dataService;
        this.dataDtoAssembler = dataDtoAssembler;
    }

    @GetMapping(value = "/{dataId}")
    public ResponseEntity<DataDTO> getData(@PathVariable Integer dataId) {
        DataEntity dataEntity = dataService.findById(dataId);
        DataDTO dataDTO = dataDtoAssembler.toModel(dataEntity);
        return new ResponseEntity<>(dataDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<DataDTO>> getAllData() {
        List<DataEntity> entityList = dataService.findAll();
        CollectionModel<DataDTO> dtos = dataDtoAssembler.toCollectionModel(entityList);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataDTO> addData(@RequestBody DataEntity entity) {
        DataEntity newEntity = dataService.create(entity);
        DataDTO dto = dataDtoAssembler.toModel(newEntity);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{dataId}")
    public ResponseEntity<?> updateData(@RequestBody DataEntity entity, @PathVariable Integer dataId) {
        dataService.update(dataId, entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{dataId}")
    public ResponseEntity<?> deleteData(@PathVariable Integer clientId) {
        dataService.delete(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/avg_temp_procedure")
    public ResponseEntity<BigDecimal> getAverageTemperature() {
        BigDecimal avgSalary = dataService.CalcMinTemperature();
        return new ResponseEntity<>(avgSalary, HttpStatus.OK);
    }
}