<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${"天生我材必有用" }
<br>
<%
String []arr={"javaweb开发经典模块大全","java范例完全自学手册","JSP项目开发全程实录"};
request.setAttribute("book", arr);
for(int i=0;i<arr.length;i++){
	request.setAttribute("request1", i);%>
${request1}:${book[request1]}<br>
<% }%>
</body>
</html>