package com.example.itplanet.model.entity;

import com.example.itplanet.validation.NotSpaces;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "animal_type")
public class AnimalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    @NotSpaces
    String type;

    @ManyToMany(mappedBy = "animalTypes",fetch = FetchType.LAZY)
    List<Animal> animals;

    public AnimalType(Long aLong) {
    }
}
