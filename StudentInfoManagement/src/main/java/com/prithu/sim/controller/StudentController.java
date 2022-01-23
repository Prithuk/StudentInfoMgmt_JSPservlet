package com.prithu.sim.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prithu.sim.dao.StudentDao;
import com.prithu.sim.dao.StudentDaoImpl;
import com.prithu.sim.dto.Student;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDao studentdao = new StudentDaoImpl();
	private static final String STUDENT_LIST = "studentDetail.jsp";
	private static final String STUDENT_NEW = "studentForm.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("actions");
		String forward = "";
		if (action.equals("student_new")) {
			forward = STUDENT_NEW;
		} else if (action.equals("student_list")) {
			forward = STUDENT_LIST;
			request.setAttribute("students", studentdao.getAllstudentInfo());
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = new Student();

		student.setStudentName(request.getParameter("sname"));
		student.setCollegeName(request.getParameter("cname"));
		student.setEmail(request.getParameter("email"));
		student.setGender(request.getParameter("gender"));
		student.setDepartment(request.getParameter("department"));
		student.setRollNumber(Integer.parseInt(request.getParameter("roll")));

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//		try {
//			Date dob = sdf.parse(request.getParameter("dob"));
//			student.setDob(dob);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// for checkbox
		String[] subjects = request.getParameterValues("subject");
		String subject = "";
		for (String sub : subjects) {
			subject = subject + sub + "/";
		}
		student.setSubject(subject);
		studentdao.saveStudentinfo(student);

	}

}
