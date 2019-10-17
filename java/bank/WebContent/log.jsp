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
			<th>转账账号</th>
			<th>收款账号</th>
			<th>转账金额</th>
		</tr>
		<c:forEach items="${pageinfo.list }" var="log">
		<tr>
		<td>${log.accOut }</td>
		<td>${log.accIn }</td>
		<td>${log.money}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="ShowServlet?pageNumber=${pageinfo.pageNumber-1}&pageSize=${pageinfo.pageSize}" <c:if test="${pageinfo.pageNumber<=1 }"> onclick="javascript:return false;" </c:if> >上一页</a>
	<a href="ShowServlet?pageNumber=${pageinfo.pageNumber+1}&pageSize=${pageinfo.pageSize}" <c:if test="${pageinfo.pageNumber>=pageinfo.total }"> onclick="javascript:return false;" </c:if> >下一页</a>
</body>
</html>