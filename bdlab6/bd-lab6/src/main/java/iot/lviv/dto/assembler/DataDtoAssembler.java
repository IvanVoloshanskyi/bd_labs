package iot.lviv.dto.assembler;


import iot.lviv.controller.DataController;
import iot.lviv.controller.IntervalOfUpdatesController;
import iot.lviv.domain.DataEntity;
import iot.lviv.dto.DataDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
@Component
public class DataDtoAssembler implements RepresentationModelAssembler<DataEntity, DataDTO> {
    @Override
    public DataDTO toModel(DataEntity entity) {
        DataDTO dataDTO = DataDTO.builder()
                .id(entity.getId())
                .temperature(entity.getTemperature())
                .humidity(entity.getHumidity())
                .wind_speed(entity.getWindSpeed())
                .atmospheric_pressure(entity.getAtmosphericPressure())
                .wind_direction(entity.getWindDirection())
                .interval_of_updates_id(entity.getIntervalOfUpdates().getId())
                .build();
        dataDTO.add(linkTo(methodOn(DataController.class).getData(dataDTO.getId())).withSelfRel(),
                linkTo(methodOn(IntervalOfUpdatesController.class).getIntervalOfUpdates(entity.getIntervalOfUpdates().getId())).withRel("IntervalOfUpdates")
        );
        return dataDTO;
    }

    @Override
    public CollectionModel<DataDTO> toCollectionModel(Iterable<? extends DataEntity> entities) {
        CollectionModel<DataDTO> dataDTOS = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DataController.class).getAllData()).withSelfRel();
        dataDTOS.add(selfLink);
        return dataDTOS;
    }
}