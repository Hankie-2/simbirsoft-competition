package com.example.itplanet.controller;

import com.example.itplanet.model.request.LocationRequest;
import com.example.itplanet.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    /**
     *  Получение информации о точке локации животных
     **/
    @GetMapping("/{pointId}")
    public ResponseEntity<?> getLocationById(@PathVariable("pointId") Long id){
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(locationService.getLocationById(id),HttpStatus.OK);
    }

    /**
     *   Добавление точки локации животных
     **/
    @PostMapping
    public ResponseEntity<?> createLocation(@RequestBody LocationRequest request){
        return new ResponseEntity<>(locationService.createLocation(request),HttpStatus.CREATED);
    }

    /**
    * Изменение точки локации животных
    **/
    @PutMapping("/{pointId}")
    public ResponseEntity<?> updateLocationById(@RequestBody LocationRequest request,@PathVariable("pointId") Long id){
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(locationService.updateLocationById(id,request),HttpStatus.OK);
    }

    /**
     * Удаление точки локации животных
     **/
    @DeleteMapping("/{pointId}")
    public ResponseEntity<?> deleteLocationById(@PathVariable("pointId")Long id){
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        locationService.deleteLocationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
