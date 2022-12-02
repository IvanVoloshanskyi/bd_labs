package iot.lviv.repository;
import iot.lviv.domain.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DataRepository extends JpaRepository <DataEntity, Integer> {
    @Query(value = "CALL CalcMinTemperature();", nativeQuery = true)
    BigDecimal getInfo();
}
