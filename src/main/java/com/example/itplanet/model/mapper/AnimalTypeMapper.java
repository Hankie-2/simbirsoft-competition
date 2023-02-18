package com.example.itplanet.model.mapper;

import com.example.itplanet.model.entity.AnimalType;
import com.example.itplanet.model.response.AnimalTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimalTypeMapper extends BaseMapper<AnimalType, AnimalTypeResponse> {
    AnimalTypeMapper INSTANCE = Mappers.getMapper(AnimalTypeMapper.class);
}
