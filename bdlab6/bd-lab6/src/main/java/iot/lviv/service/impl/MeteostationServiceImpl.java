package iot.lviv.service.impl;



import iot.lviv.domain.MeteostationEntity;
import iot.lviv.exception.EntityNotFoundException;


import iot.lviv.repository.MeteostationRepository;
import iot.lviv.service.MeteostationService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MeteostationServiceImpl implements MeteostationService {

    private final MeteostationRepository meteostationRepository;

    public MeteostationServiceImpl(MeteostationRepository meteostationRepository) {
        this.meteostationRepository = meteostationRepository;
    }

    @Override
    public List<MeteostationEntity> findAll() {
        return meteostationRepository.findAll();
    }

    @Override
    public MeteostationEntity findById(Integer id) {
        return meteostationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Meteostation", String.valueOf(id)));
    }

    @Override
    @Transactional
    public MeteostationEntity create(MeteostationEntity entity) {
        meteostationRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, MeteostationEntity entity) {
        MeteostationEntity meteostationEntity = findById(id);
        meteostationEntity.setInstallationDate(entity.getInstallationDate());
        meteostationEntity.setData(entity.getData());
        meteostationEntity.setIntervalOfUpdates(entity.getIntervalOfUpdates());
        meteostationEntity.setLocation(entity.getLocation());
        meteostationEntity.setServiceWork(entity.getServiceWork());
        meteostationEntity.setDeveloper(entity.getDeveloper());
        meteostationRepository.save(meteostationEntity);
    }

    @Override
    public void delete(Integer id) {
        MeteostationEntity meteostationEntity = findById(id);
        meteostationRepository.delete(meteostationEntity);
    }
}