package com.example.itplanet.service;

import com.example.itplanet.model.response.AnimalLocationResponse;

import java.util.List;

public interface AnimalLocationService {
    List<AnimalLocationResponse> findAnimalByLocationId(Long id);
}
