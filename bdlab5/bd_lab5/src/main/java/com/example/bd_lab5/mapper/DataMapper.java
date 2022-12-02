package com.example.bd_lab5.mapper;
import com.example.bd_lab5.DTO.DataDTO;
import com.example.bd_lab5.domain.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataMapper {

    public static DataDTO mapDataToDTO(Data data) {
        return new DataDTO(
                data.getId(),
                data.getTemperature(),
                data.getHumidity(),
                data.getWindSpeed(),
                data.getAtmosphericPressure(),
                data.getWindDirection(),
                data.getIntervalOfUpdatesId()
        );
    }

    public static Data mapDTOToData(DataDTO dataDTO) {
        return new Data(
                dataDTO.getId(),
                dataDTO.getTemperature(),
                dataDTO.getHumidity(),
                dataDTO.getWind_speed(),
                dataDTO.getAtmospheric_pressure(),
                dataDTO.getWind_direction(),
                dataDTO.getInterval_of_updates_id()
        );
    }
}