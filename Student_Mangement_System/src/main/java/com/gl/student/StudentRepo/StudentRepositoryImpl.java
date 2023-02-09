package com.gl.student.StudentRepo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gl.student.DBConnection.DBConnection;
import com.gl.student.dto.StudentDTO;

public class StudentRepositoryImpl implements StudentRepository {

	@Override
	public StudentDTO findStudent(int studentId) throws SQLException {
		Connection con = DBConnection.getConnection();
	        CallableStatement statement = null;
	        ResultSet resultSet = null;
	        StudentDTO student = null;
	        try {
	            statement = (CallableStatement) con.prepareCall("{CALL findStudent(?)}");
	            statement.setInt(1, studentId);
	            resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                student = new StudentDTO ();
	                student.setStudentId(resultSet.getInt("StudentId"));
	                student.setStudentName(resultSet.getString("StudentName"));
	                student.setStudentEmail(resultSet.getString("StudentEmail"));
	                student.setStudentAddress(resultSet.getString("StudentAddress"));
	            }
	        } catch (Exception e) {
				 System.out.println(e.getMessage());
			} finally {
	            con.close();
	        }

	        return student;
	}

	@Override
	public void addStudent(StudentDTO studentDTO) throws SQLException {
		Connection con = DBConnection.getConnection();
		 CallableStatement statement = null;
	        try {
	            statement = (CallableStatement) con.prepareCall("{CALL add_D_Student(?, ?, ?, ?)}");
	            statement.setInt(1, studentDTO.getStudentId());
	            statement.setString(2, studentDTO.getStudentName());
	            statement.setString(3, studentDTO.getStudentAddress());
	            statement.setString(4, studentDTO.getStudentEmail());
	            statement.executeUpdate();
	        }catch (Exception e) {
				 System.out.println(e.getMessage());
			}finally {
	            con.close();
	        }


	}

	@Override
	public List<StudentDTO> getStudents() throws SQLException {
		Connection con = DBConnection.getConnection();
		 List<StudentDTO> list = new ArrayList<>();
	        CallableStatement statement = (CallableStatement) con.prepareCall("{CALL getAll_student()}");
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
	        CallableStatement statement = null;
	        try {
	            statement = (CallableStatement) con.prepareCall("{CALL update_thee_Student(?, ?, ?, ?)}");
	            System.out.println(studentId);
	            statement.setInt(1, studentId);
	            statement.setString(2, student.getStudentName());
	            statement.setString(3, student.getStudentAddress());
	            statement.setString(4, student.getStudentEmail());
	            statement.executeUpdate();
	        } catch (Exception e) {
				 System.out.println(e.getMessage());
			} finally {
	            con.close();
	        }


	}

	@Override
	public void deleteStudent(int studentId) throws SQLException {
			Connection con = DBConnection.getConnection();
	        CallableStatement statement = null;
	        try {
	            statement = (CallableStatement) con.prepareCall("{CALL delete_t_Student(?)}");
	            statement.setInt(1, studentId);
	            statement.executeUpdate();
	        } finally {
	            con.close();
	        }

	}

}
