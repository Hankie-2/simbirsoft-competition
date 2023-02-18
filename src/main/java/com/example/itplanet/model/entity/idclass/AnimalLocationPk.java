package com.example.itplanet.model.entity.idclass;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class AnimalLocationPk {

    @Column(name = "animal_id")
    Long animalId;
    @Column(name = "location_id")
    Long locationId;

}
