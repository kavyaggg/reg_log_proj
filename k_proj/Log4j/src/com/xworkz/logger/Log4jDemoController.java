package com.xworkz.logger;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Log4jDemoController {

	private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	public Log4jDemoController(){
		logger.info(this.getClass().getSimpleName()+"obj created");
	}
	
	@PostMapping("/message.do")
	public String getMessage() {
		logger.info("info message -->  inside getMessage()....");
		
		logger.trace("trace message -->  inside getMessage()....");
		logger.debug("debug message -->  inside getMessage()....");
		logger.warn("warn message -->  inside getMessage()....");
		logger.error("error message -->  inside getMessage()....");
		logger.fatal("fatal message -->  inside getMessage()....");
		
		try {
			Integer.parseInt("234asdf345");
		}catch(NumberFormatException e) {
			
			logger.error("--Exception occured--", e);
			
		}
		System.out.println("inside getMessage()....");
		return "message.jsp";
		
		
	}
}

