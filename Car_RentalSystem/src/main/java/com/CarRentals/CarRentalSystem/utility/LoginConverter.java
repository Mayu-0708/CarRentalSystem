package com.CarRentals.CarRentalSystem.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.CarRentals.CarRentalSystem.entities.Login;
import com.CarRentals.CarRentalSystem.model.LoginDTO;

@Component
public class LoginConverter
{
	public LoginConverter(String string, String string2, LoginDTO loginToSystem) {
		// TODO Auto-generated constructor stub
	}

		//convert DTO to Entity
		public Login convertToLoginEntity( LoginDTO loginDTO)
		{
			Login login=new Login();
			if(loginDTO!=null)
			{
				BeanUtils.copyProperties(loginDTO, login);
			}
			return login;
		}
		
		//Convert Entity to DTO
		public LoginDTO convertToLoginDTO(Login login)
		{
			LoginDTO loginDTO=new LoginDTO();
			if(login!=null)
			{
				BeanUtils.copyProperties(login, loginDTO);
			}
			return loginDTO;
		}
}
