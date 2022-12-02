package iot.lviv.service.impl;



import iot.lviv.domain.IntervalOfUpdatesEntity;
import iot.lviv.exception.EntityNotFoundException;


import iot.lviv.repository.IntervalOfUpdatesRepository;
import iot.lviv.service.IntervalOfUpdatesService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class IntervalOfUpdatesServiceImpl implements IntervalOfUpdatesService {

    private final IntervalOfUpdatesRepository intervalOfUpdatesRepository;

    public IntervalOfUpdatesServiceImpl(IntervalOfUpdatesRepository intervalOfUpdatesRepository) {
        this.intervalOfUpdatesRepository = intervalOfUpdatesRepository;
    }

    @Override
    public List<IntervalOfUpdatesEntity> findAll() {
        return intervalOfUpdatesRepository.findAll();
    }

    @Override
    public IntervalOfUpdatesEntity findById(Integer id) {
        return intervalOfUpdatesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("IntervalOfUpdates", String.valueOf(id)));
    }

    @Override
    @Transactional
    public IntervalOfUpdatesEntity create(IntervalOfUpdatesEntity entity) {
        intervalOfUpdatesRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer id, IntervalOfUpdatesEntity entity) {
        IntervalOfUpdatesEntity intervalOfUpdatesEntity = findById(id);
        intervalOfUpdatesEntity.setInterval(entity.getInterval());
        intervalOfUpdatesRepository.save(intervalOfUpdatesEntity);
    }

    @Override
    public void delete(Integer id) {
        IntervalOfUpdatesEntity intervalOfUpdatesEntity = findById(id);
        intervalOfUpdatesRepository.delete(intervalOfUpdatesEntity);
    }
}