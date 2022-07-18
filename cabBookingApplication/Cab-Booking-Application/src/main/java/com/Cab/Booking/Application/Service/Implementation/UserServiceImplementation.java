package com.Cab.Booking.Application.Service.Implementation;

import com.Cab.Booking.Application.Entity.AppUser;
import com.Cab.Booking.Application.Entity.Location;
import com.Cab.Booking.Application.Model.AppUserModel;
import com.Cab.Booking.Application.Repository.LocationRepo;
import com.Cab.Booking.Application.Repository.UserRepo;
import com.Cab.Booking.Application.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Configuration
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepo userRepo;

    @Autowired
    LocationRepo locationRepo;

    @Override
    public String addUser(AppUserModel appUserModel){
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserModel,appUser);

        Integer locId = null;
        locId = locationRepo.findIdByLatLon(appUserModel.getLatitude(),appUserModel.getLongitude());
        if (locId == null) {
            Location location = new Location();
            location.setLon(appUserModel.getLongitude());
            location.setLat(appUserModel.getLatitude());
            Location location1 = locationRepo.save(location);
            if (location1 != null) locId = location1.getId();
            else throw new RuntimeException();
        }

        appUser.setLocationId(locId);
        AppUser appUser1 = userRepo.save(appUser);
        if (appUser1 != null){
            return "Record is saved with UserId = "+appUser1.getId()+" and Location Id is "+locId;
        }
        else throw new RuntimeException();
    }

    @Override
    public String updateUser(AppUserModel appUserModel){
        Integer locId = null;
        if (appUserModel.getLatitude()!=0 && appUserModel.getLongitude() !=0){
            locId = locationRepo.findIdByLatLon(appUserModel.getLatitude(),appUserModel.getLongitude());
            if (locId == null) {
                Location location = new Location();
                location.setLon(appUserModel.getLongitude());
                location.setLat(appUserModel.getLatitude());
                Location location1 = locationRepo.save(location);
                if (location1 != null) locId = location1.getId();
                else throw new RuntimeException();
            }
        }
        Optional<AppUser> appUserOptional = userRepo.findById(appUserModel.getId());
        locId = (locId == null) ? appUserOptional.get().getLocationId():locId;
        Long mobile = (appUserModel.getPhone() == null) ? appUserOptional.get().getPhone() : appUserModel.getPhone();
        int count = userRepo.updateMobileandLocation(locId,mobile,appUserModel.getId());
        if (count > 0)  return "Details Updated";
        else throw new RuntimeException();
    }
}
