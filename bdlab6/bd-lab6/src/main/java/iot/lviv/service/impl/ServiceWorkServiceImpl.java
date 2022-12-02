package iot.lviv.service.impl;



import iot.lviv.domain.ServiceWorkEntity;
import iot.lviv.exception.EntityNotFoundException;

import iot.lviv.repository.ServiseWorkRepository;
import iot.lviv.service.ServiceWorkService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceWorkServiceImpl implements ServiceWorkService {

    private final ServiseWorkRepository serviceWorkRepository;

    public ServiceWorkServiceImpl(ServiseWorkRepository serviceWorkRepository) {
        this.serviceWorkRepository = serviceWorkRepository;
    }

    @Override
    public List<ServiceWorkEntity> findAll() {
        return serviceWorkRepository.findAll();
    }

    @Override
    public ServiceWorkEntity findById(Integer id) {
        return serviceWorkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServiceWork", String.valueOf(id)));
    }

    @Override
    @Transactional
    public ServiceWorkEntity create(ServiceWorkEntity entity) {
        serviceWorkRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, ServiceWorkEntity entity) {
        ServiceWorkEntity serviceWorkEntity = findById(id);
        serviceWorkEntity.setDate(entity.getDate());
        serviceWorkEntity.setDescription(entity.getDescription());

        serviceWorkRepository.save(serviceWorkEntity);
    }

    @Override
    public void delete(Integer id) {
        ServiceWorkEntity serviceWorkEntity = findById(id);
        serviceWorkRepository.delete(serviceWorkEntity);
    }
}