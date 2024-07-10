package com.CarRentals.CarRentalSystem.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.CarRentals.CarRentalSystem.entities.Driver;
import com.CarRentals.CarRentalSystem.model.DriverDTO;

@Component
public class DriverConverter
{
	public DriverConverter(String string, String string2, DriverDTO dto) {
		// TODO Auto-generated constructor stub
	}

		//convert DTO to Entity
		public Driver convertToDriverEntity( DriverDTO driverDTO)
		{
			Driver driver=new Driver();
			if(driverDTO!=null)
			{
				BeanUtils.copyProperties(driverDTO, driver);
			}
			return driver;
		}
		
		//Convert Entity to DTO
		public DriverDTO convertToDriverDTO(Driver driver)
		{
			DriverDTO driverDTO=new DriverDTO();
			if(driver!=null)
			{
				BeanUtils.copyProperties(driver, driverDTO);
			}
			return driverDTO;
		}
}
