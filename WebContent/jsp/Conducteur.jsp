<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% //In case, if Editor session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Conducteur")== null) )
{
%>
<jsp:forward page="/Login.jsp"></jsp:forward>
<%} %>
<body>
<h2 align="center">Conductor's Home</h2>
 
Welcome <%=request.getAttribute("userName") %>
 
<div style="text-align: right"><a href="<%=request.getContextPath()%>/Logout">Logout</a></div>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/Trip">Trip</a></div>
 
</body>
</html>