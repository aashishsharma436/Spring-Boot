package com.Cab.Booking.Application.Service.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Cab.Booking.Application.Entity.Driver;
import com.Cab.Booking.Application.Entity.Location;
import com.Cab.Booking.Application.Model.DriverModel;
import com.Cab.Booking.Application.Model.RideModel;
import com.Cab.Booking.Application.Repository.DriverRepo;
import com.Cab.Booking.Application.Repository.LocationRepo;
import com.Cab.Booking.Application.Service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class RideServiceImplementation implements RideService {
    @Autowired
    DriverRepo driverRepo;

    @Autowired
    LocationRepo locationRepo;

    @Override
    public List<Driver> availableRides(RideModel rideModel) {
        List<Driver> driver = new ArrayList<>();
        List<Integer> locationIdList = locationRepo.findLocRideId(rideModel.getLatitude() - 5, rideModel.getLatitude() + 5,
                rideModel.getLongitude() - 5, rideModel.getLongitude() + 5);

        if (locationIdList.isEmpty()) throw new RuntimeException("No Driver is Available on this route");
        else {
            for (Integer idlist : locationIdList) {
                Optional<Location> location = locationRepo.findById(idlist);
                Double distance = (double) (Math.abs(location.get().getLat() - rideModel.getDlatitude()) +
                        Math.abs(location.get().getLon() - rideModel.getDlongitude()));
                distance *= 0.5;
                List<Driver> driverList = driverRepo.getDrivers(idlist);
                for (Driver d : driverList) {
                    d.setAmount(distance);
                    if (d.isActive()) driver.add(d);
                }
            }
            return driver;
        }
    }

    @Override
    public String rideSelected(DriverModel driverModel){
        Optional<Driver> driver = driverRepo.findById(driverModel.getId());
        double amount = driver.get().getAmount() + driverModel.getAmount();
        int count = driverRepo.updateAmount(amount,driverModel.getId());
        if (count >0) return "Updated successfully";
        else throw new RuntimeException();
    }

    @Override
    public List<String> calculateAmount() {
        List<String> amountEarned = new ArrayList<>();
        List<Driver> getDriver = driverRepo.findAll();
        for (Driver d: getDriver){
            String mesg = "Driver "+d.getName()+" with Driver Id "+d.getId()+" earned "+d.getAmount()+" Rupees.";
            amountEarned.add(mesg);
        }
        return amountEarned;
    }
}
