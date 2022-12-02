package com.example.bd_lab5.mapper;

import com.example.bd_lab5.DTO.GpsDTO;
import com.example.bd_lab5.domain.Gps;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GpsMapper {

    public static GpsDTO mapGpsToDTO(Gps gps) {
        return new GpsDTO(
                gps.getId(),
                gps.getLatitude(),
                gps.getLongtitude()
        );
    }

    public static Gps mapDTOToGps(GpsDTO gpsDTO) {
        return new Gps(
                gpsDTO.getId(),
                gpsDTO.getLatitude(),
                gpsDTO.getLongtitude()
        );
    }
}