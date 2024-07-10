package com.CarRentals.CarRentalSystem.service;

import com.CarRentals.CarRentalSystem.model.CarDTO;
import com.CarRentals.CarRentalSystem.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO dto);

    void updateCarAvailability(String rentId, String option);

    List<CustomerDTO> getAllCustomers();



}
