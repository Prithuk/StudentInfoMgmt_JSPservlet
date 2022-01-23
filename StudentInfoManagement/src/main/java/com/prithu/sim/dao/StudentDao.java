package com.prithu.sim.dao;

import java.util.List;

import com.prithu.sim.dto.Student;

public interface StudentDao {

	public void saveStudentinfo(Student student);
	public List<Student> getAllstudentInfo(); 

}
