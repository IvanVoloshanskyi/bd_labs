package com.example.bd_lab5.service;


import com.example.bd_lab5.DTO.AdressDTO;
import com.example.bd_lab5.domain.Adress;
import com.example.bd_lab5.exception.AdressNotFoundException;
import com.example.bd_lab5.mapper.AdressMapper;
import com.example.bd_lab5.repository.AdressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class AdressServise {

    private final AdressRepository adressRepository;

    public List<Adress> getAllAdress() {
        return adressRepository.findAll();
    }

    public Adress getAdressById(Integer id) {
        return adressRepository.findById(id).orElse(null);
    }

    public Adress createAdress(AdressDTO adressDTO) {
        return adressRepository.save(AdressMapper.mapDTOToAdress(adressDTO));
    }

    public Adress updateAdress(AdressDTO adressDTO) {
        if (getAdressById(adressDTO.getId()) != null) {
            return adressRepository.save(AdressMapper.mapDTOToAdress(adressDTO));
        }
        return null;
    }

    public Adress deleteAdressById(Integer id) {
        Adress adress = getAdressById(id);
        if (adress != null) {
            adressRepository.deleteById(id);
            return adress;
        }
        return null;
    }
}