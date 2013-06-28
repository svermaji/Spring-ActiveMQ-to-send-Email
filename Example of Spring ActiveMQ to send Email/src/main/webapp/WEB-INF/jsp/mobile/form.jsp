<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Create Mobile</title>
</head>
<body>

<h1>Create Mobile</h1>

<c:if test="${not empty param.created}">
	<p><b>You have successfully created a mobile.</b></p>
</c:if>

<form:form modelAttribute="mobile">
	<table>
		<tr>
			<td>Company:</td>
			<td><form:input path="company" /></td>
		</tr>
		<tr>
			<td>Model:</td>
			<td><form:input path="model" /></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit"></input></td>
		</tr>
	</table>
</form:form>

</body>
</html>
