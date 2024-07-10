package com.CarRentals.CarRentalSystem.controller;

import com.CarRentals.CarRentalSystem.model.AdminDTO;
import com.CarRentals.CarRentalSystem.model.CustomerDTO;
import com.CarRentals.CarRentalSystem.model.PaymentDTO;
import com.CarRentals.CarRentalSystem.service.PaymentService;
import com.CarRentals.CarRentalSystem.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.URIReferenceException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/addRent")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public PaymentConverter saveBooking(@RequestBody PaymentDTO dto){
        service.bookingCar(dto);
        System.out.println(dto);
        return new PaymentConverter("200","Admin added",dto);
    }

//    @PostMapping(path = "/addBooking", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//    public ResponseUtil saveBooking(RentDTO dto, @RequestPart("imgBankSlip") MultipartFile file1) {
//
//        try {
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//            File uploadsDir = new File(projectPath + "/uploads");
//            uploadsDir.mkdir();
//            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));
//
//            dto.setBankSlip("uploads/" + file1.getOriginalFilename());
//            service.bookingCar(dto);
//
//        }catch (IOException | URISyntaxException e){
//            return new ResponseUtil("Ok", "Successfully Saved", dto);
//
//        }
//        return new ResponseUtil("Ok", "Successfully Saved", dto);
//
//    }
    @GetMapping
    public PaymentConverter getAllRentRequest(){
        List<PaymentDTO> allRentRequest = service.rentRequest();
        return new PaymentConverter("Ok","ok",allRentRequest);
    }


    @PutMapping("/updateRent")
    public PaymentConverter rentCar(@RequestBody PaymentDTO dto){
        service.rentCar(dto);
        System.out.println(dto);
        return new PaymentConverter("ok" ,"booking successful",dto);
    }

    @PutMapping(params = "rentId")
    public PaymentConverter driverAvailability(@RequestParam String paymentId, @RequestParam String option){
        service.updateDriverAvailability(paymentId , option);
        return new PaymentConverter("ok" ,"booking successful"," ");
    }

    @PutMapping(params ="/updateCar/{rentId}")
    public PaymentConverter carAvailability(@RequestParam String paymentId, @RequestParam String option){
        service.updateCarAvailability(paymentId , option);
        return new PaymentConverter("ok" ,"booking successful"," ");
    }

    @DeleteMapping(params = {"rentId"})
    public PaymentConverter deleteRent(@RequestParam String licenceNo) {
        service.deleteDriver(licenceNo);
        return new PaymentConverter("200", "Deleted", null);
    }
}


