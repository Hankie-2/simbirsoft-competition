package com.example.itplanet.service;

import com.example.itplanet.model.response.AnimalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnimalService {

    AnimalResponse getAnimalByChipperId(Long id);
    boolean isAnimalExistsByTypeId(Long animalTypeId);
    AnimalResponse getAnimalById(Long id);

}
