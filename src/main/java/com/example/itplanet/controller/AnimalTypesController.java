package com.example.itplanet.controller;

import com.example.itplanet.model.request.AnimalTypeRequest;
import com.example.itplanet.service.AnimalTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@RequestMapping("/animals/types")
@RestController
@AllArgsConstructor
public class AnimalTypesController {

    private final AnimalTypeService animalTypeService;

    /**
     * Получение информации о типе животного
     **/
    @GetMapping("/{typeId}")
    public ResponseEntity<?> getAnimalTypeById(@PathVariable("typeId") Long id){
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(animalTypeService.getAnimalTypeById(id),HttpStatus.OK);
    }

    /**
     * Добавление типа животного
     **/
    @PostMapping
    public ResponseEntity<?> createAnimalType(@RequestBody AnimalTypeRequest request){
        return new ResponseEntity<>(animalTypeService.createAnimalType(request),HttpStatus.OK);
    }

    /**
     * Изменение типа животного
     **/
    @PutMapping("/{typeId}")
    public ResponseEntity<?> updateAnimalType(@PathVariable("typeId") Long id,@RequestBody AnimalTypeRequest request){
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(animalTypeService.updateAnimalTypeById(id,request),HttpStatus.OK);
    }

    /**
    * Удаление типа животного
     **/
    @DeleteMapping("/{typeId}")
    public ResponseEntity<?> deleteAnimalType(@PathVariable("typeId") Long id){
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        animalTypeService.deleteAnimalTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
