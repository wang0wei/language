<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1'>
<tr>
<th>花卉编号</th>
<th>花卉名称</th>
<th>价格</th>
<th>原产地</th>
</tr>
<c:forEach items="${list }" var="flower">
<tr>
<td>${flower.id }</td>
<td>${flower.name }</td>
<td>${flower.price }</td>
<td>${flower.production }</td>
</tr>
</c:forEach>
</table>
<a href="add.jsp">添加花卉信息</a>
</body>
</html>