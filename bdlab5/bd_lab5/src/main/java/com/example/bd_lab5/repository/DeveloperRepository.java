package com.example.bd_lab5.repository;

import com.example.bd_lab5.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository <Developer, Integer> {
}
