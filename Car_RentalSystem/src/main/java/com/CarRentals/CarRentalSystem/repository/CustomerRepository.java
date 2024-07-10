package com.CarRentals.CarRentalSystem.repository;

import com.CarRentals.CarRentalSystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , String> {


}
