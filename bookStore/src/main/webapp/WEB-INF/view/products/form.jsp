<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
	     pageEncoding="ISO-8859-1"
	     isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Store</title>
</head>
<body>

	<form action="/bookStore/products" method="post">
		<div>
			<label>Title</label>
			<input type="text" name="title">
		</div>
		<div>
			<label>Description</label>
			<textarea rows="10" cols="20" name="description"></textarea>
		</div>
		<div>
			<label>Pages</label>
			<input type="text" name="pages">
		</div>
		<c:forEach items="${types}" var="type" varStatus="status">
			<div>
				<label>${type}</label>
				<input type="text" name="prices[${status.index}].value">
				<input type="hidden" name="prices[${status.index}].type">
			</div>			
		</c:forEach>
		<button type="submit" name="save">Save</button>
	</form>

</body>
</html>