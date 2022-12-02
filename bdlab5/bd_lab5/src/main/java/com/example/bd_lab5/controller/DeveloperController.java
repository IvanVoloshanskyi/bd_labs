package com.example.bd_lab5.controller;

import com.example.bd_lab5.DTO.DeveloperDTO;
import com.example.bd_lab5.domain.Developer;
import com.example.bd_lab5.mapper.DeveloperMapper;
import com.example.bd_lab5.service.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/developer")
public class DeveloperController {
    private final DeveloperService developerService;

    @GetMapping
    public List<DeveloperDTO> getAllDeveloper() {
        return developerService.getAllDeveloper().stream().map(DeveloperMapper::mapDeveloperToDTO).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<DeveloperDTO> getDeveloperById(@PathVariable("id") Integer id) {
        Developer developer = developerService.getDeveloperById(id);
        if (developer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DeveloperMapper.mapDeveloperToDTO(developer), HttpStatus.OK);
    }

    @PostMapping
    public DeveloperDTO createDeveloper(@RequestBody DeveloperDTO developerDTO) {
        return DeveloperMapper.mapDeveloperToDTO(developerService.createDeveloper(developerDTO));
    }

    @PutMapping
    public ResponseEntity<DeveloperDTO> updateDeveloper(@RequestBody DeveloperDTO developerDTO) {
        Developer developer = developerService.getDeveloperById(developerDTO.getId());
        if (developer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DeveloperMapper.mapDeveloperToDTO(developerService.updateDeveloper(developerDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DeveloperDTO> deleteDeveloper(@PathVariable("id") Integer id) {
        Developer developer = developerService.getDeveloperById(id);
        if (developer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DeveloperMapper.mapDeveloperToDTO(developerService.deleteDeveloperById(id)), HttpStatus.OK
        );
    }

}