<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

    <a href="/welcome">Home</a> |  

    <a href="/addNewEmployee">Add
        Employee</a> |   <a
        href="/getEmployees">Show
        Employees</a> |   <u><h2 style="color: red;">
            <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            </h3></u>

    <form id="logoutForm" method="POST" action="/logout">
    </form>


</div>