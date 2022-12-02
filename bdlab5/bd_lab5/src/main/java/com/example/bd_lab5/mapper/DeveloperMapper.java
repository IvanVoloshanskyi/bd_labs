package com.example.bd_lab5.mapper;

import com.example.bd_lab5.DTO.DeveloperDTO;
import com.example.bd_lab5.domain.Developer;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DeveloperMapper {

    public static DeveloperDTO mapDeveloperToDTO(Developer developer) {
        return new DeveloperDTO(
                developer.getId(),
                developer.getName(),
                developer.getSurname(),
                developer.getTelephoneNum()
        );
    }

    public static Developer mapDTOToDeveloper(DeveloperDTO developerDTO) {
        return new Developer(
                developerDTO.getId(),
                developerDTO.getName(),
                developerDTO.getSurname(),
                developerDTO.getTelephone_num()
                );
    }
}