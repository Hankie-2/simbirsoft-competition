package com.example.itplanet.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Min(-90)
    @Max(90)
    @NotNull
    Double latitude;

    @Min(-180)
    @Max(180)
    @NotNull
    Double longitude;

    @OneToMany(mappedBy = "location")
    List<AnimalLocation> animalLocations;

}
