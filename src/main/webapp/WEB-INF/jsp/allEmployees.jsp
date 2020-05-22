<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List Employees</h1>
	 <ul>
        <c:forEach items="${employees}" var="emp">
            <li>
                <h2>${emp.id}</h2>
                <h2>${emp.name}</h2>
            </li>
        </c:forEach>
    </ul>
</body>
</html>