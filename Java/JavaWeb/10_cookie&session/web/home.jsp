<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Z Sl
  Date: 2021/9/17
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>xishuai</title>
</head>
<body>

<%

//        1. 获取所有cookie
    Cookie[] cookies = request.getCookies();
//        2. 遍历cookie
    boolean flag = false; //flag=true表示没有对应的cookie, 是首次访问
    if(cookies!=null && cookies.length>0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if("lasttime".equals(name)) {
                flag = true;
                // 有cookie, 不是第一次访问
                //获取上次访问时间
                String lastTime = cookie.getValue();

                //写入本次访问时间
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);

                //URL编码, 防止特殊符号导致的乱码
                System.out.println("编码前: " + str_date);
                str_date = URLEncoder.encode(str_date, "utf-8");
                System.out.println("编码后: " + str_date);

                cookie.setValue(str_date);
                //设置cookie存活时间
                cookie.setMaxAge(60*60*24*30); //30天
                response.addCookie(cookie);

                //URL解码
                System.out.println("解码前: " + lastTime);
                lastTime = URLDecoder.decode(lastTime, "utf-8");
                System.out.println("解码后: " + lastTime);
//                下面截断java代码, 会报错, 但是能运行
%>
                <h1>欢迎回来, 您上次访问的时间是: <%=lastTime%></h1>
               <input>
<%
                break;
            }
        }
    }
    //没有对应cookie, 是首次访问
    if(cookies == null || cookies.length==0 || flag==false) {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);

        //URL编码
        System.out.println("编码前: " + str_date);
        str_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后: " + str_date);

        Cookie cookie = new Cookie("lasttime", str_date);
        cookie.setValue(str_date);
        //设置cookie存活时间
        cookie.setMaxAge(60*60*24*30); //30天
        response.addCookie(cookie);
%>
        <h1>您好, 欢迎首次登陆: <%=str_date%></h1>

<%
    }

%>


</body>
</html>
