package iot.lviv.service.impl;



import iot.lviv.domain.DeveloperEntity;
import iot.lviv.exception.EntityNotFoundException;


import iot.lviv.repository.DeveloperRepository;

import iot.lviv.service.DeveloperService;
import iot.lviv.service.GeneralService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public List<DeveloperEntity> findAll() {
        return developerRepository.findAll();
    }

    @Override
    public DeveloperEntity findById(Integer id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer", String.valueOf(id)));
    }

    @Override
    @Transactional
    public DeveloperEntity create(DeveloperEntity entity) {
        developerRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, DeveloperEntity entity) {
        DeveloperEntity developerEntity = findById(id);
        developerEntity.setName(entity.getName());
        developerEntity.setSurname(entity.getSurname());
        developerEntity.setTelephoneNum(entity.getTelephoneNum());
        developerRepository.save(developerEntity);
    }

    @Override
    public void delete(Integer id) {
        DeveloperEntity developerEntity = findById(id);
        developerRepository.delete(developerEntity);
    }
    public void createTablesWithCursor() {
        developerRepository.createTablesWithCursor();
    }

}