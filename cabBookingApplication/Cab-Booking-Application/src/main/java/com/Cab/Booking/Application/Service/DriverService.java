package com.Cab.Booking.Application.Service;

import com.Cab.Booking.Application.Model.DriverModel;

public interface DriverService {
    String addDriver(DriverModel driverModel);
    String updateDriverLocation(DriverModel driverModel);
    String updateDriverStatus(DriverModel driverModel);
}
