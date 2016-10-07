<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>
<c:if test="${!empty listUsers}">
<table border="1">
<tr>
<td>User ID</td>
<td>First Name</td>
<td>Last Name</td>
<td>Address</td>
<td>Mobile</td>
<td>Action</td>
</tr>
<c:forEach items="${listUsers}" var="showusers">
<tr>
<td>${showusers.userId}</td>
<td>${showusers.userFirstName}</td>
<td>${showusers.userLastName}</td>
<td>${showusers.userAddress}</td>
<td>${showusers.userMobile}</td>
<td>
<c:url value="addusers/${showusers.userId}/update" var="userUrl"/>
<input type="submit" value="Edit" onclick="location.href='${userUrl}'" /></td>
</tr>
</c:forEach>
</table>
</c:if>

</body>
</html>