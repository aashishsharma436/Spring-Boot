package com.Cab.Booking.Application.Repository;

import com.Cab.Booking.Application.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepo extends JpaRepository<Location,Integer> {

    @Query(value = "select id from Location where lat = ?1 and lon = ?2",nativeQuery = true)
    Integer findIdByLatLon(int lat, int lon);

    @Query(value = "select id from Location where lat >= ?1 and lat <= ?2 and lon >= ?3 and lon <= ?4",nativeQuery = true)
    List<Integer> findLocRideId(int minlat, int maxlat, int minlon, int maxlon);
}
