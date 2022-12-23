<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022/9/19
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick22" method="post", enctype="multipart/form-data">
            名称<input type="text" name="username"><br/>
            文件1<input type="file" name="uploadFile"><br/>
            文件2<input type="file" name="uploadFile2"><br/>
            <input type="submit" value="提交">
    </form>

    <form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="name"><br>
        文件1：<input type="file" name="uploadFiles"><br>
        文件2：<input type="file" name="uploadFiles"><br>
        文件3：<input type="file" name="uploadFiles"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
