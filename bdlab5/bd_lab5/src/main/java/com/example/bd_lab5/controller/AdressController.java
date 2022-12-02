package com.example.bd_lab5.controller;

import com.example.bd_lab5.DTO.AdressDTO;
import com.example.bd_lab5.domain.Adress;
import com.example.bd_lab5.mapper.AdressMapper;
import com.example.bd_lab5.service.AdressServise;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/adress")
public class AdressController {
    private final AdressServise adressServise;

    @GetMapping
    public List<AdressDTO> getAllAdress() {
        return adressServise.getAllAdress().stream().map(AdressMapper::mapAdressToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdressDTO> getAdressById(@PathVariable("id") Integer id) {
        Adress adress = adressServise.getAdressById(id);
        if (adress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                AdressMapper.mapAdressToDTO(adress), HttpStatus.OK);
    }

    @PostMapping
    public AdressDTO createAdress(@RequestBody AdressDTO adressDTO) {
        return AdressMapper.mapAdressToDTO(adressServise.createAdress(adressDTO));
    }

    @PutMapping
    public ResponseEntity<AdressDTO> updateAdress(@RequestBody AdressDTO adressDTO) {
        Adress adress = adressServise.getAdressById(adressDTO.getId());
        if (adress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                AdressMapper.mapAdressToDTO(adressServise.updateAdress(adressDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AdressDTO> deleteAdress(@PathVariable("id") Integer id) {
        Adress adress = adressServise.getAdressById(id);
        if (adress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                AdressMapper.mapAdressToDTO(adressServise.deleteAdressById(id)), HttpStatus.OK
        );
    }

}