package com.example.bd_lab5.controller;


import com.example.bd_lab5.DTO.AdressDTO;
import com.example.bd_lab5.DTO.DataDTO;
import com.example.bd_lab5.domain.Data;
import com.example.bd_lab5.mapper.AdressMapper;
import com.example.bd_lab5.mapper.DataMapper;
import com.example.bd_lab5.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/data")
public class DataController {
    private final DataService dataService;

    @GetMapping
    public List<DataDTO> getAllData() {
        return dataService.getAllData().stream().map(DataMapper::mapDataToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDTO> getDataById(@PathVariable("id") Integer id) {
        Data data = dataService.getDataById(id);
        if (data == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DataMapper.mapDataToDTO(data), HttpStatus.OK);
    }

    @PostMapping
    public DataDTO createData(@RequestBody DataDTO dataDTO) {
        return DataMapper.mapDataToDTO(dataService.createData(dataDTO));
    }

    @PutMapping
    public ResponseEntity<DataDTO> updateData(@RequestBody DataDTO dataDTO) {
        Data data = dataService.getDataById(dataDTO.getId());
        if (data == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DataMapper.mapDataToDTO(dataService.updateData(dataDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DataDTO> deleteData(@PathVariable("id") Integer id) {
        Data data = dataService.getDataById(id);
        if (data == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DataMapper.mapDataToDTO(dataService.deleteDataById(id)), HttpStatus.OK
        );
    }

}