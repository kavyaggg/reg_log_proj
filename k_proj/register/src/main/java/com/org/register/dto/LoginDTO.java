package com.org.register.dto;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.org.register.dao.ForgotDAOImpl;



@Component

public class LoginDTO {
	private static Logger logger = Logger.getLogger(ForgotDAOImpl.class);


	private String email;
	private String password;
	
	public LoginDTO() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}
	
}
