package com.example.itplanet.model.response;

import com.example.itplanet.model.enums.AnimalGender;
import com.example.itplanet.model.enums.AnimalLifeStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;

import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnimalResponse {
    Long id;
    Long[] animalTypes;
    Float weight;
    Float length;
    Float height;
    AnimalGender gender;
    AnimalLifeStatus lifeStatus;
    TimestampWithTimeZoneJdbcType chippingDateTime;
    Integer chippedId;
    Long chippingLocationId;
    Long[] visitedLocations;
    TimestampWithTimeZoneJdbcType deathDateTime;
}
