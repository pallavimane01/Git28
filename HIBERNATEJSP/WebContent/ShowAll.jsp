<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
$(document).ready(function(){
    $("#deleteEmployee").hide();
     $("#updateEmployee").hide();
    
    $("#update").click(function(){
        $("#updateEmployee").show();
        $("#deleteEmployee").hide();
    });
    $("#delete").click(function(){
        $("#deleteEmployee").show();
         $("#updateEmployee").hide();
    });
});
</script>
    </head>
    <body>
        All Employees: <br> 
        <c:forEach var="emp" items="${employeeList}">
            Employee ID: ${emp.empId} <br>
            Employee Name: ${emp.empName} <br>
            Employee Salary: ${emp.empSalary}<br>
            Employee Contact:${emp.empContactNumber}<br>
            Employee UID:${emp.empUID}<br>
            Employee DOB:${emp.empDOB}<br>
            -------------------------------------<br>
        </c:forEach>
        
        <form action="EmployeeController" method="POST">
            Update: <input type="checkbox" id="update"> Delete: <input type="checkbox" id="delete" onclick="document.getElementById('empName').disabled=this.checked;document.getElementById('empSalary').disabled=this.checked;"><br><br>
            <select name="empId">
                <c:forEach items="${employeeList}" var="employee">
                <option value="${employee.empId}">${employee.empId}</option>
                 </c:forEach>
            </select>
            
            <br>
            Update Name: <input id="empName" type="text" name="empName"><br>
            Update Salary: <input id="empsalaryupdate" type="text" name="empSalary"> <br>
            Update Contact: <input id="empContactNumber" type="text" name="empContactNumber"><br>
            Update UID: <input id="empUID" type="text" name="empUID"><br>
            Update DOB: <input id="empDOB" type="text" name="empdob"><br><br>
            <button type="submit" id="updateEmployee" name="updateEmployee"> Update</button> <br> <br>
            <button type="submit" id="deleteEmployee" name="deleteEmployee"> Delete </button>
            
            
               
       
        </form>
    </body>
</html>
