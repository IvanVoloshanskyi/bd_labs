package iot.lviv.service.impl;



import iot.lviv.domain.LocationEntity;
import iot.lviv.exception.EntityNotFoundException;


import iot.lviv.repository.LocationRepository;
import iot.lviv.service.LocationService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationEntity> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public LocationEntity findById(Integer id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location", String.valueOf(id)));
    }

    @Override
    @Transactional
    public LocationEntity create(LocationEntity entity) {
        locationRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, LocationEntity entity) {
        LocationEntity locationEntity = findById(id);
        locationEntity.setCity(entity.getCity());
        locationEntity.setAdress(entity.getAdress());
        locationEntity.setGps(entity.getGps());
        locationRepository.save(locationEntity);
    }

    @Override
    public void delete(Integer id) {
        LocationEntity locationEntity = findById(id);
        locationRepository.delete(locationEntity);
    }

    @Override
    public List<LocationEntity> getLocationEntityByAdress(Integer adress) {
        return locationRepository.getLocationEntityByAdress(adress);
    }
}