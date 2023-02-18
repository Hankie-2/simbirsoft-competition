package com.example.itplanet.service.impl;

import com.example.itplanet.exception.animalType.AnimalTypeNotFound;
import com.example.itplanet.model.entity.Animal;
import com.example.itplanet.model.mapper.AnimalMapper;
import com.example.itplanet.model.response.AnimalResponse;
import com.example.itplanet.repository.AnimalRepository;
import com.example.itplanet.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public AnimalResponse getAnimalByChipperId(Long id) {
        Animal animal = animalRepository.findByChipperId(id);
        if(animal == null){
            return null; // NOT_FOUND
        }
        return null;
    }

    @Override
    public boolean isAnimalExistsByTypeId(Long id){
        return animalRepository.existsByAnimalTypesId(id);
    }

    @Override
    public AnimalResponse getAnimalById(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(()->new AnimalTypeNotFound(HttpStatus.NOT_FOUND));
        return AnimalMapper.INSTANCE.toDto(animal);
    }
}
