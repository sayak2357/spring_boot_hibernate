package com.luv2code.crudDemo;

import java.util.List;
import com.luv2code.crudDemo.dao.StudentDAO;
import com.luv2code.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
//		return runner ->{
//			System.out.println("Hello World!");
//		};
		return runner -> {
			//createStudent(studentDAO);
			 createStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudent(studentDAO);
			// queryForStudentByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id = 1
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);


		// update student firstName to 'scooby'
		myStudent.setFirstName("Scooby");


		// updaete the student in db
		studentDAO.update(myStudent);


		//display updated student
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Ahmed");
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();

		// display students
		for(Student tempStudent:studentList){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new tudent objects ....");
		Student tempStudent = new Student("Dummer","Voon","dummer@voon.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);

		// retrieve student based on id
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createStudents(StudentDAO studentDAO) {
		System.out.println("Creating new tudent objects ....");
		Student tempStudent1 = new Student("Sayak","Chowdhury","chowdhury.sayak@gmail.com");
		Student tempStudent2 = new Student("Sam","Ganguly","sam@gmail.com");
		Student tempStudent3 = new Student("Shahjahan","Ahmed","shahjahan@gmail.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new tudent object ....");
		Student tempStudent = new Student("Sayak","Chowdhury","chowdhury.sayak@gmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student successfully. Generated id: "+tempStudent.getId());
	}
}
