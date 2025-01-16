<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--DIRECTIVE TAG-->
<%@ include file="hello.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--DECLARATIVE TAG  -->
	<%! 
int age =22;
String name = "Akash";
String[] names = {"Ashvani","Gowthami"};%>

	<!--Expression Tags-->
	<h2><%= name %></h2>
	<h2><%= age %></h2>

	<!--Scripting Tags-->
	<% for(String n:names){ %>
	<h2><%= n %></h2>
	<%} %>

</body>
</html>