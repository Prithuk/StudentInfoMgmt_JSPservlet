package com.prithu.sim.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prithu.sim.dto.Student;
import com.prithu.sim.util.Dbutil;

public class StudentDaoImpl implements StudentDao {
	PreparedStatement ps = null;

	@Override
	public void saveStudentinfo(Student student) {
		String sql = "insert into student_tbl1(student_name,college_name,email,Roll_number,Gender,subject,department)values(?,?,?,?,?,?,?)";
		try {
			ps = Dbutil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getCollegeName());
			ps.setString(3, student.getEmail());
			ps.setInt(4, student.getRollNumber());
//			ps.setDate(5, new Date(student.getDob().getTime()));

			ps.setString(5, student.getGender());
			ps.setString(6, student.getSubject());
			ps.setString(7, student.getDepartment());

			ps.executeUpdate(); 

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getAllstudentInfo() {
		String sql = "Select * from student_tbl1";
		List<Student> studentList = new ArrayList<>();
		try {
			ps = Dbutil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("student_name"));
				student.setCollegeName(rs.getString("college_name"));
				student.setEmail(rs.getString("email"));
				student.setRollNumber(rs.getInt("roll"));
//				student.setDob(rs.getDate("dob"));
				student.setGender(rs.getString("gender"));
				student.setSubject(rs.getString("subject"));
				student.setDepartment(rs.getString("department"));
                studentList.add(student); 
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

}
