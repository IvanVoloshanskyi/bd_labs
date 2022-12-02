package iot.lviv.repository;

import iot.lviv.domain.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository <DeveloperEntity, Integer> {
    @Procedure("CreateTablesWithCursor")
    void createTablesWithCursor();
}
