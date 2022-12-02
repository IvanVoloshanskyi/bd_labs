package iot.lviv.repository;

import iot.lviv.domain.GpsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpsRepository extends JpaRepository <GpsEntity, Integer>{
}
