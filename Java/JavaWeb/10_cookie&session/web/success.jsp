<%--登陆案例: 成功页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("user")%>欢迎!</h1>
</body>
</html>
