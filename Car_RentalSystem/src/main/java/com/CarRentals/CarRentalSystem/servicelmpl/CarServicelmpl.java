package com.CarRentals.CarRentalSystem.servicelmpl;

import com.CarRentals.CarRentalSystem.model.CarDTO;
import com.CarRentals.CarRentalSystem.entities.Car;
import com.CarRentals.CarRentalSystem.entities.Customer;
import com.CarRentals.CarRentalSystem.repository.CarRepository;
import com.CarRentals.CarRentalSystem.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServicelmpl implements CarService {

    @Autowired
    CarRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if(!repo.existsById(dto.getRegistrationNO())){
        repo.save(mapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("car already added");

        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<CarDTO>>(){}.getType());
    }


}
