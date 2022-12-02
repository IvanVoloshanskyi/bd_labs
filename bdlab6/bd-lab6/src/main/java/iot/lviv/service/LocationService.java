package iot.lviv.service;

import iot.lviv.domain.LocationEntity;

import java.util.List;

public interface LocationService extends GeneralService<LocationEntity, Integer>{
    List<LocationEntity> getLocationEntityByAdress(Integer adress);
}
