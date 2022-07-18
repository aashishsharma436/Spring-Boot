package com.Cab.Booking.Application.Service.Implementation;

import com.Cab.Booking.Application.Entity.Driver;
import com.Cab.Booking.Application.Entity.Location;
import com.Cab.Booking.Application.Model.AppUserModel;
import com.Cab.Booking.Application.Model.DriverModel;
import com.Cab.Booking.Application.Repository.DriverRepo;
import com.Cab.Booking.Application.Repository.LocationRepo;
import com.Cab.Booking.Application.Service.DriverService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Configuration
@Service
public class DriverServiceImplementation implements DriverService{
	@Autowired
	LocationRepo locationRepo;

	@Autowired
	DriverRepo driverRepo;

	@Override
	public String addDriver(DriverModel driverModel) {
		Driver driver = new Driver();
		BeanUtils.copyProperties(driverModel, driver);

		Integer locId = null;
		locId = locationRepo.findIdByLatLon(driverModel.getLatitude(),driverModel.getLongitude());
		if (locId == null) {
			Location location = new Location();
			location.setLon(driverModel.getLongitude());
			location.setLat(driverModel.getLatitude());
			Location location1 = locationRepo.save(location);
			if (location1 != null) locId = location1.getId();
			else throw new RuntimeException();
		}

		driver.setLocationId(locId);
		driver.setAmount(0.0);
		Driver driver1 = driverRepo.save(driver);
		if (driver1 != null){
			return "Record is saved with DriverId = "+driver1.getId()+" and Location Id is "+locId;
		}
		else throw new RuntimeException();
	}


	@Override
	public String updateDriverLocation(DriverModel driverModel){
		Long id = driverModel.getId();
		Integer lat = driverModel.getLatitude();
		Integer lon = driverModel.getLongitude();
		Integer locId = null;
		if (lat!=0 && lon !=0){
			locId = locationRepo.findIdByLatLon(driverModel.getLatitude(),driverModel.getLongitude());
			if (locId == null) {
				Location location = new Location();
				location.setLon(driverModel.getLongitude());
				location.setLat(driverModel.getLatitude());
				Location location1 = locationRepo.save(location);
				if (location1 != null) locId = location1.getId();
				else throw new RuntimeException();
			}
		}

		int count = driverRepo.updateLocation(locId,id);
		if (count > 0) return "Location Updated";
		else throw new RuntimeException();
	}

	@Override
	public String updateDriverStatus(DriverModel driverModel){
		Long id = driverModel.getId();
		boolean status = driverModel.isActive();
		int count = driverRepo.updateStatus(status,id);
		if (count > 0) return "Status Updated";
		else throw new RuntimeException();
	}
}
