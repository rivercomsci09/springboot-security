<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<title>Show Employees</title>
</head>
<body>
  	 <sec:csrfInput />
	<jsp:include page="menu.jsp" />
	      
	<h3 style="color: red;">Show All Employees</h3>
	<ul>
		<c:forEach var="listValue" items="${employees}">
			<li>${listValue}</li>
		</c:forEach>
	</ul>
</body>
</html>