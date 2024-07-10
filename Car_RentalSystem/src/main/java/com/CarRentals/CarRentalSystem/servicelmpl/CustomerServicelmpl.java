package com.CarRentals.CarRentalSystem.servicelmpl;

import com.CarRentals.CarRentalSystem.model.CarDTO;
import com.CarRentals.CarRentalSystem.model.CustomerDTO;
import com.CarRentals.CarRentalSystem.entities.*;
import com.CarRentals.CarRentalSystem.repository.*;
import com.CarRentals.CarRentalSystem.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServicelmpl implements CustomerService {

    @Autowired
    CustomerRepository repo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    PaymentRepository rentRepo;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if(!repo.existsById(dto.getCustomerId())){
            repo.save(mapper.map(dto, Customer.class));
        }else {
            throw new RuntimeException("Customer already added");
        }
    }

    @Override
    public void updateCarAvailability(String PaymentID, String option) {
        Payment rent = rentRepo.findById(PaymentID).get();
        rent.getCar().setStatus("notAvailable");
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }


}
