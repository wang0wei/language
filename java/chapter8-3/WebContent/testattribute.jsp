<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>这是一个测试对象属性信息监听器的页面</h3>
<%
getServletContext().setAttribute("username","itcast");
getServletContext().setAttribute("username","itheima");
getServletContext().removeAttribute("username");
session.setAttribute("username","itcast");
session.setAttribute("username","itheima");
session.removeAttribute("username");
request.setAttribute("username", "itcast");
request.setAttribute("username", "itheima");
request.removeAttribute("username");

%>
</body>
</html>