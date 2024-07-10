package com.CarRentals.CarRentalSystem.controller;

import com.CarRentals.CarRentalSystem.model.DriverDTO;
import com.CarRentals.CarRentalSystem.model.LoginDTO;
import com.CarRentals.CarRentalSystem.service.LoginService;
import com.CarRentals.CarRentalSystem.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService service;

    @PostMapping
    public LoginConverter saveDriver(@RequestBody LoginDTO dto){
        service.saveLogin(dto);
        return new LoginConverter("200","Driver added",dto);
    }

    @GetMapping(path = "/{username}")
    public LoginConverter loginToSystem(@PathVariable String username) {
        return new LoginConverter("200", "Ok", service.loginToSystem(username));
    }
}
