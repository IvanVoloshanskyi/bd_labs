package com.example.bd_lab5.service;

import com.example.bd_lab5.DTO.DeveloperDTO;
import com.example.bd_lab5.DTO.GpsDTO;
import com.example.bd_lab5.domain.Developer;
import com.example.bd_lab5.domain.Gps;
import com.example.bd_lab5.mapper.DeveloperMapper;
import com.example.bd_lab5.mapper.GpsMapper;
import com.example.bd_lab5.repository.DeveloperRepository;
import com.example.bd_lab5.repository.GpsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Service
public class GpsService {

    private final GpsRepository gpsRepository;

    public List<Gps> getAllGps() {
        return gpsRepository.findAll();
    }

    public Gps getGpsById(Integer id) {
        return gpsRepository.findById(id).orElse(null);
    }

    public Gps createGps(GpsDTO gpsDTO) {
        return gpsRepository.save(GpsMapper.mapDTOToGps(gpsDTO));
    }

    public Gps updateGps(GpsDTO gpsDTO) {
        if (getGpsById(gpsDTO.getId()) != null) {
            return gpsRepository.save(GpsMapper.mapDTOToGps(gpsDTO));
        }
        return null;
    }

    public Gps deleteGpsById(Integer id) {
        Gps gps = getGpsById(id);
        if (gps != null) {
            gpsRepository.deleteById(id);
            return gps;
        }
        return null;
    }
}

