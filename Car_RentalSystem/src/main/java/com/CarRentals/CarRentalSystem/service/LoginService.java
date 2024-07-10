package com.CarRentals.CarRentalSystem.service;

import com.CarRentals.CarRentalSystem.model.DriverDTO;
import com.CarRentals.CarRentalSystem.model.LoginDTO;

public interface LoginService {

    void saveLogin (LoginDTO dto);

    LoginDTO loginToSystem(String username);


}
