package com.example.bd_lab5.repository;

import com.example.bd_lab5.domain.Location;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository <Location, Integer>{
}
