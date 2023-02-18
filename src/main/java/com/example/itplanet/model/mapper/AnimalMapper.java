package com.example.itplanet.model.mapper;

import com.example.itplanet.model.entity.Animal;
import com.example.itplanet.model.response.AnimalResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimalMapper extends BaseMapper<Animal, AnimalResponse> {
    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

}
