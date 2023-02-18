package com.example.itplanet.repository;

import com.example.itplanet.model.entity.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalTypeRepository extends JpaRepository<AnimalType,Long> {
    AnimalType findByType(String type);
}
