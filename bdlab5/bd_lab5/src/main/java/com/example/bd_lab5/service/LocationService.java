package com.example.bd_lab5.service;

import com.example.bd_lab5.DTO.IntervalOfUpdatesDTO;
import com.example.bd_lab5.DTO.LocationDTO;
import com.example.bd_lab5.domain.IntervalOfUpdates;
import com.example.bd_lab5.domain.Location;
import com.example.bd_lab5.mapper.IntervalOfUpdatesMapper;
import com.example.bd_lab5.mapper.LocationMapper;
import com.example.bd_lab5.repository.IntervalOfUpdatesRepository;
import com.example.bd_lab5.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }

    public Location createLocation(LocationDTO locationDTO) {
        return locationRepository.save(LocationMapper.mapDTOToLocation(locationDTO));
    }

    public Location updateLocation(LocationDTO locationDTO) {
        if (getLocationById(locationDTO.getId()) != null) {
            return locationRepository.save(LocationMapper.mapDTOToLocation(locationDTO));
        }
        return null;
    }

    public Location deleteLocation(Integer id) {
        Location location = getLocationById(id);
        if (location != null) {
            locationRepository.deleteById(id);
            return location;
        }
        return null;
    }

}
