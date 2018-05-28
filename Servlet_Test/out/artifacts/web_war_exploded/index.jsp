<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <hea>
      <meta charset="utf-8">
    <title>Title</title>
  </hea>
  <body>
    <form action="/loginServlet" method="post">
        用户名: <input name="username" type="text"><br>
        密码: <input name="password" type="password"><br>
        <input type="submit" value="login">
    </form>
  </body>
</html>