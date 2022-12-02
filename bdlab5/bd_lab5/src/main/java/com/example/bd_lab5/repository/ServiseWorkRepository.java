package com.example.bd_lab5.repository;

import com.example.bd_lab5.domain.ServiceWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiseWorkRepository extends JpaRepository <ServiceWork, Integer>{
}
