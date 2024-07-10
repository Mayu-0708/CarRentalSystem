package com.CarRentals.CarRentalSystem.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.CarRentals.CarRentalSystem.entities.Customer;
import com.CarRentals.CarRentalSystem.model.CustomerDTO;

@Component
public class CustomerConverter 
{
	public CustomerConverter(String string, String string2, Object object) {
		// TODO Auto-generated constructor stub
	}

	//convert DTO to Entity
	public Customer convertToCustomerEntity(CustomerDTO customerDTO)
	{
		Customer customer=new Customer();
		if(customerDTO!=null)
		{
			BeanUtils.copyProperties(customerDTO, customer);
		}
		return customer;
	}
	
	//Convert Entity to DTO
	public CustomerDTO convertToCustomerDTO(Customer  customer)
	{
		CustomerDTO customerDTO=new CustomerDTO();
		if(customer!=null)
		{
			BeanUtils.copyProperties(customer, customerDTO);
		}
		return customerDTO;
	}
	
}
