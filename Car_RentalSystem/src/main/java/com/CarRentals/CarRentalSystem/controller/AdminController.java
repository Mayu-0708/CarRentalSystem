package com.CarRentals.CarRentalSystem.controller;

import com.CarRentals.CarRentalSystem.model.AdminDTO;
import com.CarRentals.CarRentalSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.CarRentals.CarRentalSystem.utility.AdminConverter;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService service;




    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminConverter saveAdmin(@RequestBody AdminDTO dto){
        service.saveAdmin(dto);
        return new AdminConverter("200","Admin added",dto);
    }
}
