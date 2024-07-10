package com.CarRentals.CarRentalSystem.repository;

import com.CarRentals.CarRentalSystem.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,String> {
}
