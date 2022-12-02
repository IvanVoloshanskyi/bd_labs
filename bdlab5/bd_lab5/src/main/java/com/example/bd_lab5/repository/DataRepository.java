package com.example.bd_lab5.repository;

import com.example.bd_lab5.domain.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository <Data, Integer> {

}
