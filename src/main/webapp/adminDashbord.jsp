<%
if(session.getAttribute("name")==null)
{
	response.sendRedirect("login.jsp");
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Admin Dashboard here ...
<a class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>
</body>
</html>