package iot.lviv.repository;


import iot.lviv.domain.IntervalOfUpdatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalOfUpdatesRepository extends JpaRepository <IntervalOfUpdatesEntity, Integer>{
}
