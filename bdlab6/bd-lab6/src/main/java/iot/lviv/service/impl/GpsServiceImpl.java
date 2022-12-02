package iot.lviv.service.impl;



import iot.lviv.domain.GpsEntity;
import iot.lviv.exception.EntityNotFoundException;


import iot.lviv.repository.GpsRepository;
import iot.lviv.service.GpsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GpsServiceImpl implements GpsService {

    private final GpsRepository gpsRepository;

    public GpsServiceImpl(GpsRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
    }

    @Override
    public List<GpsEntity> findAll() {
        return gpsRepository.findAll();
    }

    @Override
    public GpsEntity findById(Integer id) {
        return gpsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gps", String.valueOf(id)));
    }

    @Override
    @Transactional
    public GpsEntity create(GpsEntity entity) {
        gpsRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, GpsEntity entity) {
        GpsEntity gpsEntity = findById(id);
        gpsEntity.setLatitude(entity.getLatitude());
        gpsEntity.setLongtitude(entity.getLongtitude());
        gpsRepository.save(gpsEntity);
    }

    @Override
    public void delete(Integer id) {
        GpsEntity gpsEntity = findById(id);
        gpsRepository.delete(gpsEntity);
    }
}