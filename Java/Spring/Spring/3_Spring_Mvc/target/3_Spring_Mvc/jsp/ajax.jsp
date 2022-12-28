<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022/9/18
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>

    <script>
        //模拟数据
        var userList = new Array();
        userList.push({username: "zhangsan",age: "20"});
        userList.push({username: "lisi",age: "20"});

        $.ajax({
            type: "POST",
            url: "/3_Spring_Mvc_war_exploded/user/quick15",
            data: JSON.stringify(userList),
            contentType : 'application/json;charset=utf-8'
        });
    </script>
</head>
<body>

</body>
</html>
