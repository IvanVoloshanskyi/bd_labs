package com.example.bd_lab5.mapper;


import com.example.bd_lab5.DTO.AdressDTO;
import com.example.bd_lab5.domain.Adress;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AdressMapper {

    public static AdressDTO mapAdressToDTO(Adress adress) {
        return new AdressDTO(
                adress.getId(),
                adress.getAdress(),
                adress.getStreet(),
                adress.getBuild()
        );
    }

    public static Adress mapDTOToAdress(AdressDTO adressDTO) {
        return new Adress(
                adressDTO.getId(),
                adressDTO.getAdress(),
                adressDTO.getStreet(),
                adressDTO.getBuild()
        );
    }
}