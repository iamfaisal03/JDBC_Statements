package com.gl.student.StudentRepo;

import java.sql.SQLException;
import java.util.List;

import com.gl.student.dto.StudentDTO;

public interface StudentRepository {

	public StudentDTO findStudent (int studentId) throws SQLException;
	public void addStudent(StudentDTO studentDTO) throws SQLException;
	public List<StudentDTO> getStudents()throws SQLException;
	public void updateStudent(int studentId, StudentDTO student) throws SQLException;
	public void deleteStudent(int studentId)throws SQLException;
}
