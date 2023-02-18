package com.example.itplanet.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangeAnimalTypeRequest {
    @NotNull
    @Min(1)
    Long oldTypeId;

    @NotNull
    @Min(1)
    Long newTypeId;
}
