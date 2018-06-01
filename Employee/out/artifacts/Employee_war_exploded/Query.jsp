<%--
  Created by IntelliJ IDEA.
  User: tjut_
  Date: 2018/6/1
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Query</title>
</head>
<body>
    <form action="/EmployeeServlet" method="post">
        <center>
            <input type="hidden" name="kind" value="queryEmployee">

            <table>
                <tr>
                    <th>查询</th>
                    <td><input name="QueryID"></td>
                </tr>
                <%--<tr>
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
                </tr>--%>
                <tr>
                    <td colspan="2"><center><input type="submit"></center></td>
                </tr>
            </table>
        </center>
    </form>
</body>
</html>
