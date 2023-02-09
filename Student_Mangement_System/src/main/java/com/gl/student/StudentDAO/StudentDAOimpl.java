package com.gl.student.StudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.gl.student.DBConnection.DBConnection;
import com.gl.student.dto.StudentDTO;

public class StudentDAOimpl implements StudentDAO {

	@Override
	public StudentDTO findStudent(int studentId) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM student WHERE StudentId = ?");
        statement.setInt(1, studentId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("StudentName");
            String email = resultSet.getString("StudentEmail");
            String address = resultSet.getString("StudentAddress");
            return new StudentDTO(studentId,name,email,address);
        }
        else
        return null;
	}

	@Override
	public void addStudent(StudentDTO studentDTO) throws SQLException {
		   Connection con = DBConnection.getConnection();
		   PreparedStatement statement = con.prepareStatement("INSERT INTO student  VALUES (?,?,?,?)");
	        statement.setInt(1, studentDTO.getStudentId());
	        statement.setString(2, studentDTO.getStudentName());
	        statement.setString(3, studentDTO.getStudentEmail());
	        statement.setString(4, studentDTO.getStudentAddress());
	        statement.executeUpdate();

	}

	@Override
	public List<StudentDTO> getStudents() throws SQLException {
		List<StudentDTO> list = new ArrayList<>();
		 Connection con = DBConnection.getConnection();
		 PreparedStatement statement = con.prepareStatement("select * from student");
		 ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			StudentDTO dto = new StudentDTO();
			dto.setStudentId(resultSet.getInt("StudentId"));
			dto.setStudentName(resultSet.getString("StudentName"));
			dto.setStudentEmail(resultSet.getString("StudentEmail"));
			dto.setStudentAddress(resultSet.getString("StudentAddress"));
			list.add(dto);
		}
		return list;
	}

	@Override
	public void updateStudent(int studentId, StudentDTO student) throws SQLException {
		Connection con = DBConnection.getConnection();
		 PreparedStatement statement = con.prepareStatement("UPDATE student SET StudentName = ?, StudentEmail = ?, StudentAddress = ? WHERE StudentId = ?");
	        statement.setString(1, student.getStudentName());
	        statement.setString(2, student.getStudentEmail());
	        statement.setString(3, student.getStudentAddress());
	        statement.setInt(4, studentId);
	        statement.executeUpdate();

	}

	@Override
	public void deleteStudent(int studentId) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement statement = con.prepareStatement("DELETE FROM student WHERE StudentId = ?");
        statement.setInt(1, studentId);
        statement.executeUpdate();

	}

}
