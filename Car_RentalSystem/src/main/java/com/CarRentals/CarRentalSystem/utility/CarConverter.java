package com.CarRentals.CarRentalSystem.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.CarRentals.CarRentalSystem.entities.Car;
import com.CarRentals.CarRentalSystem.model.CarDTO;

@Component
public class CarConverter
{
	public CarConverter(String string, String string2, CarDTO carDTO) {
		// TODO Auto-generated constructor stub
	}

		//convert DTO to Entity
		public Car convertToCarEntity(CarDTO carDTO)
		{
			Car car=new Car();
			if(carDTO!=null)
			{
				BeanUtils.copyProperties(carDTO, car);
			}
			return car;
		}
		
		//Convert Entity to DTO
		public CarDTO convertToCarDTO(Car car)
		{
			CarDTO carDTO=new CarDTO();
			if(car!=null)
			{
				BeanUtils.copyProperties(car, carDTO);
			}
			return carDTO;
		}
}
