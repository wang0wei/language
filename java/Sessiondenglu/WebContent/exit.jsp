<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
session.invalidate();//销毁session
response.sendRedirect("index.jsp");//重定向页面到index.jsp
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>销毁session并重定向到index.jsp</title>
</head>
<body>
销毁session并重定向到index.jsp
</body>
</html>