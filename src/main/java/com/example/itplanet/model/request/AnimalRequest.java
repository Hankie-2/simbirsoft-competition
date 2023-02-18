package com.example.itplanet.model.request;

import com.example.itplanet.model.enums.AnimalGender;
import com.example.itplanet.model.enums.AnimalLifeStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnimalRequest {
    Long[] animalTypes;
    Float weight;
    Float length;
    Float height;
    AnimalGender gender;
    Integer chippedId;
    Long chippingLocationId;
}
