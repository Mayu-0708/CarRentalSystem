package com.CarRentals.CarRentalSystem.servicelmpl;

import com.CarRentals.CarRentalSystem.model.DriverDTO;
import com.CarRentals.CarRentalSystem.entities.Driver;
import com.CarRentals.CarRentalSystem.repository.DriverRepository;
import com.CarRentals.CarRentalSystem.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DriverServicelmpl implements DriverService {

    @Autowired
    DriverRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getLicenceNo())){
            repo.save(mapper.map(dto, Driver.class));
        }else {
            throw new RuntimeException("Driver Already Added");
        }
    }
}
