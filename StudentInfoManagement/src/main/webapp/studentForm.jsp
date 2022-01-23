<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student registration Form</title>
<%@ include file="header.jsp"%>
</head>
<body>

	<div>
		<fieldset>
			<legend>Student Registration Form</legend>
			<form action="StudentController" method="Post">

				<div>
					<label>Student Name</label> <input type="text" name="sname">
				</div>

				<div>
					<label>College Name</label> <input type="text" name="cname">
				</div>

				<div>
					<label>E-mail</label> <input type="email" name="email">
				</div>

				<div>
					<label>Roll Number</label> <input type="number" name="roll">
				</div>
				
				<!--   <div>
					<label>DOB</label> <input type="datetime" name="dob">
				</div> -->

				<div>
					<label>Gender</label> <input type="radio" name="gender"
						value="Male"> Male <input type="radio" name="gender"
						value="Female"> Female
				</div>

				<div>
					<label>Subject</label> <input type="checkbox" name="subject"
						value="JAVA">JAVA <input type="checkbox" name="subject"
						value="C">C <input type="checkbox" name="subject"
						value="C++">C++ <input type="checkbox" name="subject"
						value="Python">Python
				</div>



				<div>
					<label>Department</label> <select name="department">
						<option value="BCT">BCT</option>
						<option value="BCE">BCE</option>
						<option value="BCX">BCX</option>
						<option value="BEL">BEL</option>


					</select>
				</div>
				
				<div>
					<input type="submit" value="Submit">
				</div>
			</form>
		</fieldset>
	</div>
</body>
</html>