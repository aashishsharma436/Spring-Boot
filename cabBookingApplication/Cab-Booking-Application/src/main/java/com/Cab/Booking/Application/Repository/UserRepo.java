package com.Cab.Booking.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Cab.Booking.Application.Entity.AppUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo extends JpaRepository<AppUser, Long> {

    @Transactional
    @Modifying
    @Query(value = "Update APP_USER set location_Id = ?1, phone  = ?2 where id = ?3 ",nativeQuery = true)
    Integer updateMobileandLocation(Integer locId, Long mobile ,Long id);

}
