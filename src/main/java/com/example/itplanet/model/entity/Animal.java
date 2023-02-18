package com.example.itplanet.model.entity;

import com.example.itplanet.model.enums.AnimalGender;
import com.example.itplanet.model.enums.AnimalLifeStatus;
import com.example.itplanet.validation.ElementOfCollectionNotNull;
import com.example.itplanet.validation.MinCollectionSize;
import com.example.itplanet.validation.NotGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    @MinCollectionSize
    @ElementOfCollectionNotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "animal_types",
    joinColumns = {@JoinColumn(name = "animal_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "type_id",referencedColumnName = "id")})
    List<AnimalType> animalTypes;

    @NotNull
    @Min(1)
    Float weight;

    @NotNull
    @Min(1)
    Float length;

    @NotNull
    @Min(1)
    Float height;

    @NotNull
    @NotGender
    AnimalGender gender;

    AnimalLifeStatus lifeStatus;

    TimestampWithTimeZoneJdbcType chippingDateTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "chipper_id")
    Account chipperId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "chipping_location_id")
    Location chippingLocationId;

    @OneToMany(mappedBy = "animal")
    List<AnimalLocation> visitedLocations;

    TimestampWithTimeZoneJdbcType deathDateTime;

}