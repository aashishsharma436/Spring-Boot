package com.Cab.Booking.Application.Service;

import com.Cab.Booking.Application.Entity.Driver;
import com.Cab.Booking.Application.Model.DriverModel;
import com.Cab.Booking.Application.Model.RideModel;

import java.util.List;

public interface RideService {
    List<Driver> availableRides(RideModel rideModel);
    String rideSelected(DriverModel driverModel);
    List<String> calculateAmount();
}
