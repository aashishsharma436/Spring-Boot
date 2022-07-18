package com.Cab.Booking.Application.Controller;

import com.Cab.Booking.Application.Entity.Driver;
import com.Cab.Booking.Application.Model.AppUserModel;
import com.Cab.Booking.Application.Model.DriverModel;
import com.Cab.Booking.Application.Model.RideModel;
import com.Cab.Booking.Application.Service.DriverService;
import com.Cab.Booking.Application.Service.RideService;
import com.Cab.Booking.Application.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CabBooking {
    @Autowired
    UserService userService;

    @Autowired
    DriverService driverService;

    @Autowired
    RideService rideService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody AppUserModel appUserModel){
        String mesg = userService.addUser(appUserModel);
        return new ResponseEntity<>(mesg, HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody AppUserModel appUserModel){
        String mesg = userService.updateUser(appUserModel);
        return new ResponseEntity<>(mesg,HttpStatus.OK);
    }

    @PostMapping("/addDriver")
    public ResponseEntity<String> addDriver(@RequestBody DriverModel driverModel){
        String mesg = driverService.addDriver(driverModel);
        return new ResponseEntity<>(mesg, HttpStatus.OK);
    }

    @PutMapping("/updateDvrLoc")
    public ResponseEntity<String> updateDvrLoc(@RequestBody DriverModel driverModel){
        String mesg = driverService.updateDriverLocation(driverModel);
        return new ResponseEntity<>(mesg, HttpStatus.OK);
    }

    @PutMapping("/updateDvrStatus")
    public ResponseEntity<String> updateDvrStatus(@RequestBody DriverModel driverModel){
        String mesg = driverService.updateDriverStatus(driverModel);
        return new ResponseEntity<>(mesg, HttpStatus.OK);
    }

    @GetMapping("/availableRides")
    public ResponseEntity<List<Driver>> getAvailableDrivers(@RequestBody RideModel rideModel){
        List<Driver> drivers = rideService.availableRides(rideModel);
        return new ResponseEntity<>(drivers,HttpStatus.OK);
    }

    @PutMapping("/selectDriver")
    public ResponseEntity<String> selectDriver(@RequestBody DriverModel driverModel){
        String mesg = rideService.rideSelected(driverModel);
        return new ResponseEntity<>(mesg, HttpStatus.OK);
    }

    @GetMapping("/getAllAmount")
    public ResponseEntity<List<String>> getAllAmount(){
        List<String> amount = rideService.calculateAmount();
        return new ResponseEntity<>(amount,HttpStatus.OK);
    }

}
