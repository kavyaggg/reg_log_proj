package com.org.register.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.register.dto.ForgotDTO;
import com.org.register.service.ForgotService;

@Component
@RequestMapping
public class ForgotController {
	private static Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private ForgotService service;

	public ForgotController() {
		logger.info(this.getClass().getSimpleName() + " obj created!");
	}

	@RequestMapping("/forgot.do")
	public String onForgot(ForgotDTO dto, ModelMap map) {
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

			String C = this.service.validateForgot(dto);
			boolean valid = this.service.validateForgotPassword(dto);
			if (valid) {
				ModelMap success = map.addAttribute("email", dto.getEmail());
				ModelMap success1 = map.addAttribute("password", dto.getPassword());
				ModelMap success2 = map.addAttribute("confirmPassword", dto.getConfirmPassword());
			} else {
				ModelMap failure = map.addAttribute("failureMessage", "forgotPassword unsuccessfull");
			}

			logger.info("Invoked onForgot method");
			logger.info(dto);

		} catch(NumberFormatException e) {
			
			logger.error("--Exception occured--", e);
			
		}
		return "Forgot";
	}
}
