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
chef drh dashboard here ..
<a class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>

<form method="post" action="generatePdf">
    <!-- Add other form fields as needed -->
    <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
    <input type="hidden" name="userId" value="<%= request.getParameter("userId") %>">
    <input type="hidden" name="email" value="<%= request.getParameter("email") %>">
    <input type="hidden" name="phone" value="<%= request.getParameter("phone") %>">
    <input type="hidden" name="profession" value="<%= request.getParameter("profession") %>">
    <!-- Add other form fields as needed -->

    <!-- Add a button to trigger PDF generation -->
    <input type="submit" value="Generate Attestation" class="profile-edit-btn" name="GenerateAttestation">
</form>
</body>
</html>