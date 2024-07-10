package com.CarRentals.CarRentalSystem.servicelmpl;

import com.CarRentals.CarRentalSystem.model.PaymentDTO;
import com.CarRentals.CarRentalSystem.entities.Payment;
import com.CarRentals.CarRentalSystem.repository.*;
import com.CarRentals.CarRentalSystem.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public  class PaymentServicelmpl implements PaymentService {


    @Autowired
    PaymentRepository rentRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    CarRepository carRepo;

    @Autowired
    DriverRepository driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void bookingCar(PaymentDTO dto) {
        if (!rentRepo.existsById(dto.getRentId())){
            Payment rent = mapper.map(dto, Payment.class);
            rentRepo.save(rent);

        }else {
            throw new RuntimeException("Booking was added Already");
        }

    }

    @Override
    public List<PaymentDTO> rentRequest() {
        List<Payment> all = rentRepo.findAll();
        return mapper.map(all,new TypeToken<List<PaymentDTO>>(){}.getType());
    }


    @Override
    public void rentCar(PaymentDTO dto) {
        if (rentRepo.existsById(dto.getPaymentId())) {
            Payment rent = mapper.map(dto, Payment.class);
            rentRepo.save(rent);
        } else {
            throw new RuntimeException("Booking was added Already");

        }
    }

    @Override
    public void updateDriverAvailability(String PaymentId, String option) {
        Payment rent = rentRepo.findById(PaymentId).get();
        rent.getDriver().setAvailability("notAvailable");
        rentRepo.save(rent);
    }

    @Override
    public void updateCarAvailability(String PaymentId, String option) {
    	Payment rent = rentRepo.findById(PaymentId).get();
        rent.getCar().setStatus("notAvailable");
    }


    @Override
    public void deleteDriver(String PaymentId) {
        if (rentRepo.existsById(PaymentId)) {
            rentRepo.deleteById(PaymentId);
        } else {
            throw new RuntimeException("No Such Driver To Delete");
        }
    }
}