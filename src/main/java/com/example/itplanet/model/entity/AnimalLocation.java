package com.example.itplanet.model.entity;

import com.example.itplanet.model.entity.idclass.AnimalLocationPk;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "animal_locations")
public class AnimalLocation {

    @EmbeddedId
    AnimalLocationPk id;

    @ManyToOne
    @MapsId("animalId")
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    Animal animal;

    @ManyToOne
    @MapsId("locationId")
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    Location location;

    @Column(name = "visit_datetime")
    TimestampWithTimeZoneJdbcType dateTimeOfVisitLocationPoint;

}
