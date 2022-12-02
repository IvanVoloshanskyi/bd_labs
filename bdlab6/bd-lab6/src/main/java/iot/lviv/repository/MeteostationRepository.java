package iot.lviv.repository;

import iot.lviv.domain.MeteostationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeteostationRepository extends JpaRepository <MeteostationEntity, Integer>{
}
