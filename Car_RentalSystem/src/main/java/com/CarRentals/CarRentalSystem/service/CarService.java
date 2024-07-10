package com.CarRentals.CarRentalSystem.service;

import com.CarRentals.CarRentalSystem.model.CarDTO;
import com.CarRentals.CarRentalSystem.model.CustomerDTO;

import java.util.List;

public interface CarService {

    void saveCar(CarDTO dto);

    List<CarDTO> getAllCars();
}
