package com.example.itplanet.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnimalLocationResponse {
    Long id;
    ZonedDateTime dateTimeOfVisitLocationPoint;
    Long locationPointId;
}
