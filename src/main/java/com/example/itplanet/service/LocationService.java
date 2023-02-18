package com.example.itplanet.service;

import com.example.itplanet.model.entity.Location;
import com.example.itplanet.model.request.LocationRequest;
import com.example.itplanet.model.response.LocationResponse;

public interface LocationService {
    LocationResponse getLocationById(Long id);
    boolean isLocationExistsByLatitudeAndLongitude(Double latitude, Double longitude);
    LocationResponse createLocation(LocationRequest request);
    LocationResponse updateLocationById(Long id,LocationRequest request);
    void deleteLocationById(Long id);
}
