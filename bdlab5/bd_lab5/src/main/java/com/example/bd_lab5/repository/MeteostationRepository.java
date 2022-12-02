package com.example.bd_lab5.repository;

import com.example.bd_lab5.domain.Meteostation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeteostationRepository extends JpaRepository <Meteostation, Integer>{
}
