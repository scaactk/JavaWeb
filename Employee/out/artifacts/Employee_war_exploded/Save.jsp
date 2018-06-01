<%--
  Created by IntelliJ IDEA.
  User: tjut_
  Date: 2018/5/29
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Employee</title>
      <center><h2>Enter Employee Information</h2></center>
  </head>
  <body>
  <center>
    <form action="/EmployeeServlet" method="post">
        <input type="hidden" name="kind" value="saveEmployee">
        <table>
            <tr>
                <th>ID</th>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <th>First name</th>
                <td><input type="text" name="firstname"></td>
            </tr>
            <tr>
                <th>Last name</th>
                <td><input type="text" name="lastname"></td>
            </tr>
            <tr>
                <th>Department</th>
                <td><input type="text" name="department"></td>
            </tr>
            <tr>
                <td colspan="2"><center><input type="submit"></center></td>
            </tr>
        </table>
    </form>
  </center>
  </body>
</html>
