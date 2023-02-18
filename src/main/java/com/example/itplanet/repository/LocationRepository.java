package com.example.itplanet.repository;

import com.example.itplanet.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

    @Query("SELECT COUNT(l) FROM Location l WHERE l.latitude = :latitude AND l.longitude = :longitude")
    int findLocationByLatitudeAndLongitude(Double latitude,Double longitude);

}
