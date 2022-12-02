package com.example.bd_lab5.service;

import com.example.bd_lab5.DTO.GpsDTO;
import com.example.bd_lab5.DTO.IntervalOfUpdatesDTO;
import com.example.bd_lab5.domain.Gps;
import com.example.bd_lab5.domain.IntervalOfUpdates;
import com.example.bd_lab5.mapper.GpsMapper;
import com.example.bd_lab5.mapper.IntervalOfUpdatesMapper;
import com.example.bd_lab5.repository.GpsRepository;
import com.example.bd_lab5.repository.IntervalOfUpdatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Service
public class IntervalOfUpdatesService {

    private final IntervalOfUpdatesRepository intervalOfUpdatesRepository;

    public List<IntervalOfUpdates> getAllIntervalOfUpdates() {
        return intervalOfUpdatesRepository.findAll();
    }

    public IntervalOfUpdates getIntervalOfUpdatesById(Integer id) {
        return intervalOfUpdatesRepository.findById(id).orElse(null);
    }

    public IntervalOfUpdates createIntervalOfUpdates(IntervalOfUpdatesDTO intervalOfUpdatesDTO) {
        return intervalOfUpdatesRepository.save(IntervalOfUpdatesMapper.mapDTOToIntervalOfUpdates(intervalOfUpdatesDTO));
    }

    public IntervalOfUpdates updateIntervalOfUpdates(IntervalOfUpdatesDTO intervalOfUpdatesDTO) {
        if (getIntervalOfUpdatesById(intervalOfUpdatesDTO.getId()) != null) {
            return intervalOfUpdatesRepository.save(IntervalOfUpdatesMapper.mapDTOToIntervalOfUpdates(intervalOfUpdatesDTO));
        }
        return null;
    }

    public IntervalOfUpdates deleteIntervalOfUpdatesById(Integer id) {
        IntervalOfUpdates interval = getIntervalOfUpdatesById(id);
        if (interval != null) {
            intervalOfUpdatesRepository.deleteById(id);
            return interval;
        }
        return null;
    }
}
