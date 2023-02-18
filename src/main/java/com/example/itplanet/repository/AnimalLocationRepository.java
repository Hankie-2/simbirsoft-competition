package com.example.itplanet.repository;

import com.example.itplanet.model.entity.AnimalLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalLocationRepository extends JpaRepository<AnimalLocation, AnimalLocationRepository> {
    List<AnimalLocation> findByLocationId(Long locationId);
}
