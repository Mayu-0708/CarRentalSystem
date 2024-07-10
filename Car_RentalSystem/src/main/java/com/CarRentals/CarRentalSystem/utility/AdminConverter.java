package com.CarRentals.CarRentalSystem.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.CarRentals.CarRentalSystem.entities.Admin;
import com.CarRentals.CarRentalSystem.model.AdminDTO;


@Component
public class AdminConverter 
{
	public AdminConverter(String string, String string2, AdminDTO dto) {
		// TODO Auto-generated constructor stub
	}

	//convert DTO to Entity
	public Admin convertToAdminEntity(AdminDTO adminDTO)
	{
		Admin admin=new Admin();
		if(adminDTO!=null)
		{
			BeanUtils.copyProperties(adminDTO, admin);
		}
		return admin;
	}
	
	//Convert Entity to DTO
	public AdminDTO convertToAdminDTO(Admin admin)
	{
		AdminDTO adminDTO=new AdminDTO();
		if(admin!=null)
		{
			BeanUtils.copyProperties(admin, adminDTO);
		}
		return adminDTO;
	}
	
}
