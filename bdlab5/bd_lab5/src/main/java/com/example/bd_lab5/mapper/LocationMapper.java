package com.example.bd_lab5.mapper;

import com.example.bd_lab5.DTO.IntervalOfUpdatesDTO;
import com.example.bd_lab5.DTO.LocationDTO;
import com.example.bd_lab5.domain.IntervalOfUpdates;
import com.example.bd_lab5.domain.Location;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocationMapper {
    public static LocationDTO mapLocationToDTO(Location location) {
        return new LocationDTO(
                location.getId(),
                location.getCity(),
                location.getAdressId(),
                location.getGpsId()


        );
    }

    public static Location mapDTOToLocation(LocationDTO locationDTO) {
        return new Location(
                locationDTO.getId(),
                locationDTO.getCity(),
                locationDTO.getAdress_id(),
                locationDTO.getGps_id()

        );
    }
}