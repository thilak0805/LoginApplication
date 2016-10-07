<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Users</title>
</head>
<body>
<form:form action="addusers.html"  commandName="addusers">
	<table>
		<tr>
			<td>First Name:<FONT color="red"><form:errors
				path="userFirstName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userFirstName" /></td>
		</tr>
		<tr>
			<td>Last Name:<FONT color="red"><form:errors
				path="userLastName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userLastName" /></td>
		</tr>
		<tr>
			<td>Address:<FONT color="red"><form:errors
				path="userAddress" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userAddress" /></td>
		</tr>
		<tr>
			<td>Mobile:<FONT color="red"><form:errors
				path="userMobile" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userMobile" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
	
<h3> Persons List </h3>

<c:if test="${!empty listPersons}">

<table>
<tr>
<td>User IDD</td>
<td>First NameE</td>
<td>Last Name</td>
<td>Address</td>
<td>Mobile</td>
<td>Action</td>
</tr>
<c:forEach items="${listPersons}" var="addusers">
<tr>
<td>${addusers.userId}</td>
<td>${addusers.userFirstName}</td>
<td>${addusers.userLastName}</td>
<td>${addusers.userAddress}</td>
<td>${addusers.userMobile}</td>
</tr>
</c:forEach>
</table>
</c:if>
</form:form>
</body>
</html>