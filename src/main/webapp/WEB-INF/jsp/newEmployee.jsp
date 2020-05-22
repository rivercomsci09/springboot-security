<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<body>
    <h1>Add new employee</h1>
        
    <form:form modelAttribute="form">
        <form:errors path="" element="div" />
        <div>
            <form:label path="name">Name</form:label>
            <form:input path="name" />
            <form:errors path="name" />
        </div>
        <div>
            <input type="submit" />
        </div>
    </form:form>
</body>
</html>