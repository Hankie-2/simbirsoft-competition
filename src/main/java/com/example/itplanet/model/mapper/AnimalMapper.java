package com.example.itplanet.model.mapper;

import com.example.itplanet.model.entity.Animal;
import com.example.itplanet.model.entity.AnimalType;
import com.example.itplanet.model.response.AnimalResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface AnimalMapper extends BaseMapper<Animal, AnimalResponse> {
    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    @Override
    @Named("toDto")
    @Mapping(source = "animalTypes", target = "animalTypes", qualifiedByName = "toArray")
    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "height", target = "height")
    @Mapping(source = "length", target = "length")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "lifeStatus", target = "lifeStatus")
    @Mapping(source = "chippingDateTime", target = "chippingDateTime")
    @Mapping(source = "chipperId.id", target = "chippedId")
    @Mapping(source = "chippingLocationId", target = "chippingLocationId")
    @Mapping(source = "visitedLocations", target = "visitedLocations",qualifiedByName = "toArray")
    @Mapping(source = "deathDateTime", target = "deathDateTime")
    AnimalResponse toDto(Animal entity);

    @Override
    @IterableMapping(qualifiedByName = "toDto")
    List<AnimalResponse> toDtoList(List<Animal> entityList);

    @Override
    @Named("toEntity")
    @Mapping(source = "animalTypes", target = "animalTypes", qualifiedByName = "toArrayList")
    Animal toEntity(AnimalResponse dto);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Animal> toEntityList(List<AnimalResponse> dtoList);

    @Named("toArray")
    default Long[] toArray(List<AnimalType> animalTypes) {
        return animalTypes.stream()
                .map(a -> a.getId())
                .toArray(Long[]::new);
    }

    @Named("toArrayList")
    default List<AnimalType> toArrayList(Long[] animalTypes) {
        return Arrays.stream(animalTypes)
                .map(AnimalType::new) // new object just for example purposes, you can instead call the repository findById
                .collect(Collectors.toList());
    }

}
