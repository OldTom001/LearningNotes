
<%--登陆案例: 登陆页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <script>
<%--        给图片绑定单机事件: 单机更换验证码--%>
        window.onload=function () {
            document.getElementById("img").onclick=function () {
                this.src="/cookie_war_exploded/checkCodeServlet?" + new Date().getTime();
            }
        }
    </script>

    <style>
        div{
            color: red;
        }
    </style>

</head>
<body>
<form action="/cookie_war_exploded/loginServlet1" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/cookie_war_exploded/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登陆"></td>
        </tr>

    </table>

</form>
<div>
<%--    显示错误信息--%>
<%--    有数据则显示, 没数据则显示空字符串--%>
    <%=
    request.getAttribute("cc_error")==null?"":request.getAttribute("cc_error")
    %>
</div>

<div>
    <%=
    request.getAttribute("login_error")==null?"":request.getAttribute("login_error")
    %>
</div>
</body>
</html>
