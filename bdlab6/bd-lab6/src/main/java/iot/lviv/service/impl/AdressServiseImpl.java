package iot.lviv.service.impl;



import iot.lviv.domain.AdressEntity;
import iot.lviv.exception.EntityNotFoundException;
import iot.lviv.repository.AdressRepository;
import iot.lviv.service.AdressService;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class AdressServiseImpl implements AdressService{

    private final AdressRepository adressRepository;

    public AdressServiseImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public List<AdressEntity> findAll() {
        return adressRepository.findAll();
    }

    @Override
    public AdressEntity findById(Integer id) {
        return adressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Adress", String.valueOf(id)));
    }

    @Override
    @Transactional
    public AdressEntity create(AdressEntity entity) {
        adressRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, AdressEntity entity) {
        AdressEntity adressEntity = findById(id);
        adressEntity.setAdress(entity.getAdress());
        adressEntity.setStreet(entity.getStreet());
        adressEntity.setBuild(entity.getBuild());
        adressRepository.save(adressEntity);
    }

    @Override
    public void delete(Integer id) {
        AdressEntity adressEntity = findById(id);
        adressRepository.delete(adressEntity);
    }

    @Override
    public void insertTenAdress(String adress, String street,String build){
        adressRepository.insertTenAdress(adress, street, build);
    };
}