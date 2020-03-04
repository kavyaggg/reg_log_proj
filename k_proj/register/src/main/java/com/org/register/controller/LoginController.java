package com.org.register.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.register.dto.LoginDTO;
import com.org.register.service.LoginService;

@Controller
@RequestMapping
public class LoginController {
	private static Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private LoginService service;

	public LoginController() {
		logger.info(this.getClass().getSimpleName() + " obj created!");

	}

	@RequestMapping("/login.do")
	public String onLogin(LoginDTO dto, ModelMap map) {
		logger.info("info message -->  inside getMessage()....");

		/*
		 * logger.trace("trace message -->  inside getMessage()....");
		 * logger.debug("debug message -->  inside getMessage()....");
		 * logger.warn("warn message -->  inside getMessage()....");
		 * 
		 * 
		 */
		logger.warn("warn message -->  inside getMessage()....");
		logger.error("error message -->  inside getMessage()....");
		 
		//logger.fatal("fatal message -->  inside getMessage()....");


		try {
			logger.info("Invoked onRegister method");
			logger.info(dto);

			boolean check = this.service.validateLogin(dto);

			if (check) {
				
				ModelMap email = map.addAttribute("email", dto.getEmail());
				ModelMap email2 = map.addAttribute("password", dto.getPassword());
				return "Success";
				
			} else {
				ModelMap failure = map.addAttribute("failureMessage", "Login unsuccessfull");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Info:" + e.getMessage());
		}

		return "login";
	}
}
