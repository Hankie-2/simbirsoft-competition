package com.example.itplanet.model.mapper;

import com.example.itplanet.model.entity.Location;
import com.example.itplanet.model.response.LocationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper extends BaseMapper<Location, LocationResponse> {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);
}
