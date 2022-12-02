package com.example.bd_lab5.service;
import com.example.bd_lab5.DTO.DeveloperDTO;
import com.example.bd_lab5.domain.Developer;
import com.example.bd_lab5.mapper.DeveloperMapper;
import com.example.bd_lab5.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public List<Developer> getAllDeveloper() {
        return developerRepository.findAll();
    }

    public Developer getDeveloperById(Integer id) {
        return developerRepository.findById(id).orElse(null);
    }

    public Developer createDeveloper(DeveloperDTO developerDTO) {
        return developerRepository.save(DeveloperMapper.mapDTOToDeveloper(developerDTO));
    }

    public Developer updateDeveloper(DeveloperDTO developerDTO) {
        if (getDeveloperById(developerDTO.getId()) != null) {
            return developerRepository.save(DeveloperMapper.mapDTOToDeveloper(developerDTO));
        }
        return null;
    }

    public Developer deleteDeveloperById(Integer id) {
        Developer developer = getDeveloperById(id);
        if (developer != null) {
            developerRepository.deleteById(id);
            return developer;
        }
        return null;
    }
}

