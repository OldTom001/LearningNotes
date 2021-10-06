<%--
  Created by IntelliJ IDEA.
  User: Z Sl
  Date: 2021/9/18
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    session.setAttribute("name", "李四");
    request.setAttribute("name", "张三");
    session.setAttribute("age", "23");
%>

<h3>el获取值</h3>

${requestScope.name}
${sessionScope.age}

${name}
</body>
</html>
