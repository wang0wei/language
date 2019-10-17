<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>
<%
		String username = "";
		String password = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {//如果之前保存了
			for (Cookie c : cookies) {
				if (c.getName().equals("username")) {
					username = URLDecoder.decode(c.getValue(), "utf-8");
				}
				if (c.getName().equals("password")) {
					password = URLDecoder.decode(c.getValue(), "utf-8");
				}
			}
		}
	%>
<div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
     <h1>登录界面</h1>
     <form action="dologin.jsp" method="post" name="loginForm">
       <table>
         <tr>
            <td>账号:</td>
            <td><input name="name" type="text" value="<%=username%>"></td>
         </tr>
         <tr>
            <td>密码:</td>
            <td ><input name="password" type="password" value="<%=password%>"></td>
         </tr>
         <tr>
            <td ><input name="isUseCookie" type="checkbox" checked="checked">十天内自动登录</td>
         </tr>
       </table>
       <input type="submit"  value="登录" style="font-size: 16px"> 
       &nbsp;&nbsp;<a href="register.jsp" style="text-decoration:none">注册</a>
     </form>
  </div>
</body>
</html>