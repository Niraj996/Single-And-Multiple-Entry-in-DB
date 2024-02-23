package com.sgring.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sgring.cruddemo.Repo.StudentRepo;
import com.sgring.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	/*
	 * This will allow us to focus on hibernate / Jpa
	 * Debugging is very easy using the command-line runner interface because
	 * we don't need to explicitly call the particular resources via API calls,
	 * we can call them using the run method of the command-line runner interface
	 * that is executed immediately once the application is executed successfully.
	 */

	@Bean
	public CommandLineRunner commandLineRunner(StudentRepo studentRepo) { // inject Student DAO
		return runner -> {
			// createStudent(studentRepo);
			createMultipleStudent(studentRepo);
		};
	}

	private void createMultipleStudent(StudentRepo studentRepo) {
		// create the student object
		System.out.println("Creating new student object..");
		Student tempStudent1 = new Student("Dev", "Rackton", "dev@Rackton.com");
		Student tempStudent2 = new Student("Jack", "Black", "jack@black.com");
		Student tempStudent3 = new Student("Paul", "Water", "pule@water.com");	
		Student tempStudent4 = new Student("Will", "Smit", "will@smith.com");	

		// save the student object
		System.out.println("Saving the student...");
		studentRepo.save(tempStudent1);
		studentRepo.save(tempStudent2);
		studentRepo.save(tempStudent3);
		studentRepo.save(tempStudent4);
	}
				
					/***  Single data input  ***/

	// private void createStudent(StudentRepo studentRepo) {
	// 	// create the student object
	// 	System.out.println("Creating new student object..");
	// 	Student tempStudent = new Student("Pule", "Doa", "pule@doe.com");

	// 	// save the student object
	// 	System.out.println("Saving the student...");
	// 	studentRepo.save(tempStudent);

	// 	// display id of the saved student
	// 	System.out.println("Saved student. Generated id: " + tempStudent.getId());

	// }
}
