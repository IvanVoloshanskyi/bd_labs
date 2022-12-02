package iot.lviv.repository;

import iot.lviv.domain.ServiceWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiseWorkRepository extends JpaRepository <ServiceWorkEntity, Integer>{
    List<ServiceWorkEntity> getServiceWorkEntitiesByDate(Integer date);

}
