package com.example.itplanet.service.impl;

import com.example.itplanet.exception.animal.AnimalIsExists;
import com.example.itplanet.exception.animalType.AnimalTypeIsExists;
import com.example.itplanet.exception.animalType.AnimalTypeNotFound;
import com.example.itplanet.model.entity.AnimalType;
import com.example.itplanet.model.mapper.AnimalTypeMapper;
import com.example.itplanet.model.request.AnimalTypeRequest;
import com.example.itplanet.model.response.AnimalTypeResponse;
import com.example.itplanet.repository.AnimalRepository;
import com.example.itplanet.repository.AnimalTypeRepository;
import com.example.itplanet.service.AnimalTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalTypeImpl implements AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;
    private final AnimalRepository animalRepository;

    @Override
    public AnimalTypeResponse getAnimalTypeById(Long id) {
        AnimalType animalType = animalTypeRepository.findById(id).orElseThrow(()->new AnimalTypeNotFound(HttpStatus.NOT_FOUND));
        return AnimalTypeMapper.INSTANCE.toDto(animalType);
    }

    @Override
    public AnimalTypeResponse createAnimalType(AnimalTypeRequest request) {
        AnimalType animalType = animalTypeRepository.findByType(request.getType());
        if(animalType!=null){
            throw new AnimalTypeIsExists(HttpStatus.CONFLICT);
        }
        return AnimalTypeMapper.INSTANCE.toDto(animalTypeRepository.save(AnimalType.builder().type(request.getType()).build()));
    }

    @Override
    public AnimalTypeResponse updateAnimalTypeById(Long id, AnimalTypeRequest request) {
        AnimalType animalType = animalTypeRepository.findById(id).orElseThrow(()->new AnimalTypeNotFound(HttpStatus.NOT_FOUND));
        AnimalType animalTypeIsNull = animalTypeRepository.findByType(request.getType());
        if(animalTypeIsNull != null){
            throw new AnimalIsExists(HttpStatus.CONFLICT);
        }
        animalType.setType(request.getType());
        return AnimalTypeMapper.INSTANCE.toDto(animalTypeRepository.save(animalType));
    }

    @Override
    public void deleteAnimalTypeById(Long id) {
        AnimalType animalType = animalTypeRepository.findById(id).orElseThrow(()->new AnimalTypeNotFound(HttpStatus.NOT_FOUND));
        if(animalRepository.existsByAnimalTypesId(id)){
            throw new AnimalIsExists(HttpStatus.BAD_REQUEST);
        }
        animalTypeRepository.delete(animalType);
    }


}