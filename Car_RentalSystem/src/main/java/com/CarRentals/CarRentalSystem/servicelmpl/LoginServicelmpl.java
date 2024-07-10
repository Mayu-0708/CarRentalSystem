package com.CarRentals.CarRentalSystem.servicelmpl;

import com.CarRentals.CarRentalSystem.model.LoginDTO;
import com.CarRentals.CarRentalSystem.entities.Login;
import com.CarRentals.CarRentalSystem.repository.LoginRepository;
import com.CarRentals.CarRentalSystem.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginServicelmpl implements LoginService {

    @Autowired
    LoginRepository loginRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveLogin(LoginDTO dto) {
            loginRepo.save(mapper.map(dto,Login.class));
    }

    @Override
    public LoginDTO loginToSystem(String username) {
        if (loginRepo.existsById(username)) {
            return mapper.map(loginRepo.findById(username).get(),LoginDTO.class);
        }else {
            throw new RuntimeException("Driver Not Found...");

        }

        }
}
