package com.gl.student.Driver;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.gl.student.StudentRepo.StudentRepositoryImpl;
import com.gl.student.dto.StudentDTO;

public class DriverCallable {

	public static void main(String[] args) throws SQLException {

		StudentRepositoryImpl studentRepo = new StudentRepositoryImpl();
		Scanner scanner = new Scanner(System.in);

		try {
			while (true) {
				int i = 0;
				System.out.println("\nIf you want to perform some" + "\n1-> AddStudent" + "\n 2-> GetAllStduentDetails"
						+ "\n3-> Update Student Details " + "\n4-> Delete" + "\n5-> findById" + "\n6->For Exit");
				int number = scanner.nextInt();
				if (number == 1) {
					System.out.println("Enter the student id = ");
					int id = scanner.nextInt();
					System.out.println("Enter the Student Name = ");
					String name = scanner.next();
					System.out.println("Enter the address of student = ");
					String address = scanner.next();
					System.out.println("Enter the stduent email = ");
					String email = scanner.next();
					StudentDTO student = new StudentDTO(id, name, address, email);
					studentRepo.addStudent(student);
					System.out.println("Student added successfully");
				} 
				else if (number == 2) {
					System.out.println(studentRepo.getStudents());
				} 
				else if (number == 3) {
					System.out.println("Enter the stduentId you want to update = ");
					int studentId = scanner.nextInt();
					System.out.println("Enter the Student Name = ");
					String name = scanner.next();
					System.out.println("Enter the stduent email = ");
					String email = scanner.next();
					System.out.println("Enter the address of student = ");
					String address = scanner.next();
					StudentDTO studentdto = new StudentDTO(studentId, name, address, email);
					studentRepo.updateStudent(studentId, studentdto);
					System.out.println("Updated successfully");
				} 
				else if (number == 4) {
					System.out.println("Enter the stduentId = ");
					int studentId = scanner.nextInt();
					studentRepo.deleteStudent(studentId);
					System.out.println("Deleted successfully");
				} 
				else if (number == 5) {
					System.out.println("Enter the stduentId = ");
					int studentId = scanner.nextInt();
					System.out.println(studentRepo.findStudent(studentId));
				}
				else {
					i = 6;
				}
				if (i == 6) {
					System.out.println("SuccessFully Exited from the application");
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println(e);
		}

	}
}
