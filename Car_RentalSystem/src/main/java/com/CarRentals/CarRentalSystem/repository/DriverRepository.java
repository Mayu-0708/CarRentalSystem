package com.CarRentals.CarRentalSystem.repository;

import com.CarRentals.CarRentalSystem.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,String> {

    Driver findByLicenceNo(String licenceNo);
}
