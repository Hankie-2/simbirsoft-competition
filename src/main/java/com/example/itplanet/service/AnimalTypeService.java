package com.example.itplanet.service;

import com.example.itplanet.model.request.AnimalTypeRequest;
import com.example.itplanet.model.response.AnimalTypeResponse;

public interface AnimalTypeService {
    AnimalTypeResponse getAnimalTypeById(Long id);
    AnimalTypeResponse createAnimalType(AnimalTypeRequest request);
    AnimalTypeResponse updateAnimalTypeById(Long id,AnimalTypeRequest request);
    void deleteAnimalTypeById(Long id);
}
