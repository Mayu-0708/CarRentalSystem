package com.CarRentals.CarRentalSystem.servicelmpl;

import com.CarRentals.CarRentalSystem.model.AdminDTO;
import com.CarRentals.CarRentalSystem.entities.Admin;
import com.CarRentals.CarRentalSystem.repository.AdminRepository;
import com.CarRentals.CarRentalSystem.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServicelmpl implements AdminService {

    @Autowired
    AdminRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getAdminId())){
            repo.save(mapper.map(dto,Admin.class));
        }
        else {
            throw new RuntimeException("Admin Already Exists");
        }
    }
}
