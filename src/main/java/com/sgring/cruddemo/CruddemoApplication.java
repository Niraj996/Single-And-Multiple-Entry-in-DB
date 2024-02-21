package com.sgring.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args); 
	}
		/*  This will allow us to focus on hibernate / Jpa
		Debugging is very easy using the command-line runner interface because 
		we don't need to explicitly call the particular resources via API calls,
		 we can call them using the run method of the command-line runner interface 
		that is executed immediately once the application is executed successfully. */

		@Bean
		public CommandLineRunner commandLineRunner (String[] args) {
			return runner -> {
				System.out.println("hello world"); // Executed after the Spring Beans have been loaded
			};
		}
	}


