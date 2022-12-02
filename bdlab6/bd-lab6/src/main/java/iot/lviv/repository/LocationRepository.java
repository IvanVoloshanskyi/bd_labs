package iot.lviv.repository;


import iot.lviv.domain.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository <LocationEntity, Integer>{
    List<LocationEntity> getLocationEntityByAdress(Integer adress);
}
