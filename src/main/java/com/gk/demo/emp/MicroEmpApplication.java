package com.gk.demo.emp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.gk.demo.emp")
@RestController
public class MicroEmpApplication {
	
	private final static Logger LOGGER = LogManager.getLogger(MicroEmpApplication.class);
	
	@GetMapping("/")
	public String home() {
		LOGGER.info("LOG LEVEl ---->"+"\n" +"ALL"+"\n"+
				"TRACE"+"\n"+"DEBUG"+"\n"+"INFO"+"\n"+"WARN"+"\n"+"ERROR"+"\n"+"FATAL"+"\n"+"OFF");
		return "Hello from micro-emp !";
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroEmpApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
