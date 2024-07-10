package com.CarRentals.CarRentalSystem.repository;

import com.CarRentals.CarRentalSystem.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}
