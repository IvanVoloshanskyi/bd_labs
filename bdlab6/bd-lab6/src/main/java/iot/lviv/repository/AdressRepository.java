package iot.lviv.repository;
import iot.lviv.domain.AdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository <AdressEntity, Integer> {
    @Procedure("insertTenAdress")
    void insertTenAdress(String adress, String street,String build);
}
