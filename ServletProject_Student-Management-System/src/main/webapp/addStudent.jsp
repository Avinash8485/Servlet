<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Students Details :-</h1>

<form action="add-student" method="post">

	<input type="number" placeholder="Enter the StudentId" name="studentId"><br>
	<input type="text" placeholder="Enter the StudentName" name="studentName"><br>
	<input type="text" placeholder="Enter the StudentEmail" name="studentEmail"><br>
	<input type="number" placeholder="Enter the StudentAge" name="studentAge"><br>
	<input type="text" placeholder="Enter the StudentCourse" name="studentCourse"><br>
	<input type="text" placeholder="Enter the StudentCity" name="studentCity"><br>
	<input type="submit" value="ADD">

</form>
</body>
</html>