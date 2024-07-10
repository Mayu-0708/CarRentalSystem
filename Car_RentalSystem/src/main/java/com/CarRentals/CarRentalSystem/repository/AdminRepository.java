package com.CarRentals.CarRentalSystem.repository;

import com.CarRentals.CarRentalSystem.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String > {
}
