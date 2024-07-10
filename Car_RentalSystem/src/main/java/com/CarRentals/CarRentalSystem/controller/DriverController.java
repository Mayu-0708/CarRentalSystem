package com.CarRentals.CarRentalSystem.controller;

import com.CarRentals.CarRentalSystem.model.DriverDTO;
import com.CarRentals.CarRentalSystem.service.DriverService;
import com.CarRentals.CarRentalSystem.utility.DriverConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService service;

    @PostMapping
    public DriverConverter saveDriver(@RequestBody DriverDTO dto){
         service.saveDriver(dto);
        return new DriverConverter("200","Driver added",dto);
    }
}
