package com.CarRentals.CarRentalSystem.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.CarRentals.CarRentalSystem.entities.Payment;
import com.CarRentals.CarRentalSystem.model.PaymentDTO;



@Component
public class PaymentConverter 
{
	//convert DTO to Entity
	public Payment convertToPaymentEntity(PaymentDTO paymentDTO)
	{
		Payment payment=new Payment();
		if(paymentDTO!=null)
		{
			BeanUtils.copyProperties(paymentDTO, payment);
		}
		return payment;
	}
	
	//Convert Entity to DTO
	public PaymentDTO convertToPaymentDTO(Payment  payment)
	{
		PaymentDTO paymentDTO=new PaymentDTO();
		if(payment!=null)
		{
			BeanUtils.copyProperties(payment, paymentDTO);
		}
		return paymentDTO;
	}
	
}
