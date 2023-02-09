package com.gl.student.Driver;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.gl.student.StudentDAO.StudentDAOimpl;
import com.gl.student.dto.StudentDTO;

public class Driver {

	public static void main(String[] args) throws SQLException {
		StudentDAOimpl studentdaoimpl = new StudentDAOimpl();
		Scanner scanner = new Scanner(System.in);

		try {
			while (true) {
				int i = 0;
				System.out.println("===============Welcome Student Mangement System===============================" );
				System.out.println("_____________________________________________________________________________");
				System.out.println("\n1-> AddStudent" + "\n2-> GetAllStduentDetails"
						+ "\n3-> Update Student Details " + "\n4-> Delete" + "\n5->For Exit");
				int number = scanner.nextInt();
				if (number == 1) {
					System.out.println("Enter the student id = ");
					int id = scanner.nextInt();
					System.out.println("Enter the Student Name = ");
					String name = scanner.next();
					System.out.println("Enter the stduent email = ");
					String email = scanner.next();
					System.out.println("Enter the address of student = ");
					String address = scanner.next();
					StudentDTO student = new StudentDTO(id, name, address, email);
					studentdaoimpl.addStudent(student);
					System.out.println("Student added successfully");
				}
				
				else if (number == 2) {
					System.out.println(studentdaoimpl.getStudents());
				} 
				
				else if (number == 3) {
					System.out.println("Enter the stduentId = ");
					int studentId = scanner.nextInt();
					System.out.println("Enter the Student Name = ");
					String name = scanner.next();
					System.out.println("Enter the stduent email = ");
					String email = scanner.next();
					System.out.println("Enter the address of student = ");
					String address = scanner.next();
					StudentDTO studentdto = new StudentDTO(studentId, name, address, email);
					studentdaoimpl.updateStudent(studentId, studentdto);
					System.out.println("Updated successfully");
				} 
				
				else if (number == 4) {
					System.out.println("Enter the stduentId = ");
					Integer studentId = scanner.nextInt();
					studentdaoimpl.deleteStudent(studentId);
					System.out.println("Deleted successfully");
				}
				
				else {
					i = 5;
				}
				
				if (i == 5) {
					System.out.println("SuccessFully Exited from the application");
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println(e);
		}

	}
}
