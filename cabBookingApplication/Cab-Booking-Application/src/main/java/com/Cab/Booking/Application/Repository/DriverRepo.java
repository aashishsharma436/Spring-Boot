package com.Cab.Booking.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Cab.Booking.Application.Entity.Driver;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, Long>{

    @Transactional
    @Modifying
    @Query(value = "update driver set location_id = ?1 where id = ?2",nativeQuery = true)
    int updateLocation(Integer locId, Long id);


    @Transactional
    @Modifying
    @Query(value = "update driver set active = ?1 where id = ?2",nativeQuery = true)
    int updateStatus(boolean status, Long id);

    @Transactional
    @Modifying
    @Query(value = "update driver set amount = ?1 where id = ?2",nativeQuery = true)
    int updateAmount(double amount, Long id);

    @Query(value = "select * from driver where location_id = ?1",nativeQuery = true)
    List<Driver> getDrivers(Integer locationId);

    @Query(value = "select sum(amount) from driver",nativeQuery = true)
    Double amount();

}
