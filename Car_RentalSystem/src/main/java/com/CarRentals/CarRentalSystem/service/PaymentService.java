package com.CarRentals.CarRentalSystem.service;

import com.CarRentals.CarRentalSystem.model.PaymentDTO;

import java.util.List;

public interface PaymentService {

    void bookingCar(PaymentDTO dto);

    List<PaymentDTO> rentRequest();

    void rentCar(PaymentDTO dto);

     void updateDriverAvailability(String paymentID, String option);

    void updateCarAvailability(String paymentID, String option);

    void deleteDriver(String licenceNo);

}
