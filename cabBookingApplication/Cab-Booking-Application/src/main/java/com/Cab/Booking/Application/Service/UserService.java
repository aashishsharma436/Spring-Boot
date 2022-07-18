package com.Cab.Booking.Application.Service;

import com.Cab.Booking.Application.Model.AppUserModel;

public interface UserService {

    String addUser(AppUserModel appUserModel);
    String updateUser(AppUserModel appUserModel);

}
