package com.example.itplanet.repository;

import com.example.itplanet.model.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

    @Query("SELECT a FROM Animal a WHERE a.chipperId =:id")
    Animal findByChipperId(Long id);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Animal a JOIN a.animalTypes t WHERE t.id = :animalTypeId")
    boolean existsByAnimalTypesId(@Param("animalTypeId") Long animalTypeId);

}
