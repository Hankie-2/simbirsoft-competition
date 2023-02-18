package com.example.itplanet.service.impl;

import com.example.itplanet.model.entity.AnimalLocation;
import com.example.itplanet.model.response.AnimalLocationResponse;
import com.example.itplanet.repository.AnimalLocationRepository;
import com.example.itplanet.service.AnimalLocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalLocationServiceImpl implements AnimalLocationService {

    private final AnimalLocationRepository animalLocationRepository;

    @Override
    public List<AnimalLocationResponse> findAnimalByLocationId(Long id) {
        List<AnimalLocation> animalLocation = animalLocationRepository.findByLocationId(id);
        if(animalLocation.size()==0){

        }
        return null;
    }
}
