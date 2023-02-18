package com.example.itplanet.service.impl;

import com.example.itplanet.exception.animal.AnimalIsExists;
import com.example.itplanet.exception.location.LocationIsExists;
import com.example.itplanet.exception.location.LocationNotFound;
import com.example.itplanet.model.entity.Animal;
import com.example.itplanet.model.entity.Location;
import com.example.itplanet.model.mapper.LocationMapper;
import com.example.itplanet.model.request.LocationRequest;
import com.example.itplanet.model.response.LocationResponse;
import com.example.itplanet.repository.AnimalRepository;
import com.example.itplanet.repository.LocationRepository;
import com.example.itplanet.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final AnimalRepository animalRepository;

    @Override
    public LocationResponse getLocationById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(()-> new LocationNotFound(HttpStatus.NOT_FOUND));
        return LocationMapper.INSTANCE.toDto(location);
    }

    @Override
    public boolean isLocationExistsByLatitudeAndLongitude(Double latitude, Double longitude) {
        return locationRepository.findLocationByLatitudeAndLongitude(latitude,longitude)>0;
    }

    @Override
    public LocationResponse createLocation(LocationRequest request) {
        if(isLocationExistsByLatitudeAndLongitude(request.getLatitude(),request.getLongitude())){
            throw new LocationIsExists(HttpStatus.CONFLICT);
        }
        return LocationMapper.INSTANCE.toDto(locationRepository.save(Location.builder().latitude(request.getLatitude()).longitude(request.getLongitude()).build()));
    }

    @Override
    public LocationResponse updateLocationById(Long id, LocationRequest request) {
        Location location = locationRepository.findById(id).orElseThrow(()-> new LocationNotFound(HttpStatus.NOT_FOUND));
        if(isLocationExistsByLatitudeAndLongitude(request.getLatitude(),request.getLongitude())){
            throw new LocationIsExists(HttpStatus.CONFLICT);
        }
        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());
        return LocationMapper.INSTANCE.toDto(locationRepository.save(location));
    }

    @Override
    public void deleteLocationById(Long id) {
        Animal animal = animalRepository.findByChipperId(id);
        if(animal != null){
            throw new AnimalIsExists(HttpStatus.BAD_REQUEST);
        }
        locationRepository.deleteById(id);
    }

}
