package com.example.bd_lab5.mapper;

import com.example.bd_lab5.DTO.IntervalOfUpdatesDTO;
import com.example.bd_lab5.domain.IntervalOfUpdates;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IntervalOfUpdatesMapper {
    public static IntervalOfUpdatesDTO mapIntervalOfUpdatesToDTO(IntervalOfUpdates intervalOfUpdates) {
        return new IntervalOfUpdatesDTO(
                intervalOfUpdates.getId(),
                intervalOfUpdates.getInterval()

        );
    }

    public static IntervalOfUpdates mapDTOToIntervalOfUpdates(IntervalOfUpdatesDTO intervalOfUpdatesDTO) {
        return new IntervalOfUpdates(
                intervalOfUpdatesDTO.getId(),
                intervalOfUpdatesDTO.getInterval()

        );
    }
}
