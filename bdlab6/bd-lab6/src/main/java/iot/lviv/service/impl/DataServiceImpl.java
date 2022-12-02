package iot.lviv.service.impl;



import iot.lviv.domain.DataEntity;
import iot.lviv.exception.EntityNotFoundException;

import iot.lviv.repository.DataRepository;


import iot.lviv.service.DataService;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public List<DataEntity> findAll() {
        return dataRepository.findAll();
    }

    @Override
    public DataEntity findById(Integer id) {
        return dataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Data", String.valueOf(id)));
    }

    @Override
    @Transactional
    public DataEntity create(DataEntity entity) {
        dataRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, DataEntity entity) {
        DataEntity dataEntity = findById(id);
        dataEntity.setTemperature(entity.getTemperature());
        dataEntity.setHumidity(entity.getHumidity());
        dataEntity.setWindSpeed(entity.getWindSpeed());
        dataEntity.setAtmosphericPressure(entity.getAtmosphericPressure());
        dataEntity.setWindDirection(entity.getWindDirection());
        dataEntity.setIntervalOfUpdates(entity.getIntervalOfUpdates());
        dataRepository.save(dataEntity);
    }

    @Override
    public void delete(Integer id) {
        DataEntity dataEntity = findById(id);
        dataRepository.delete(dataEntity);
    }
    @Override
    public BigDecimal CalcMinTemperature() {
        return dataRepository.getInfo();
    }

}