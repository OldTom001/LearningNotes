<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022/9/18
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
        <input type="text" name="userList[0].username"><br>
        <input type="text" name="userList[0].age"><br>
        <input type="text" name="userList[1].username"><br>
        <input type="text" name="userList[1].age"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
