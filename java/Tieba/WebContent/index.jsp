<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.DB.DBconn" import="java.util.ArrayList"
	import="com.entity.Message"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-color: #f0f0f0;
}

.all {
	background-color: #ffffff;
	margin-left: 20%;
	margin-right: 20%;
	margin-top:10px;
	margin-bottom:10px;
	border-radius:10px;
}

.name {
	margin-right: 10px;
}

.a {
	text-decoration: none;
	align: left;
	margin-top: 2px;
	color: blue;
}
</style>
<meta charset="UTF-8">
<title>贴吧</title>
</head>
<body>
	<%@ include file="head.jsp"%>

	<%
		String sql = "select * from message";
		ArrayList<Message> list = new ArrayList<Message>();
		list = DBconn.getMessageList(sql);//将数据库里面的所有信息存到list中
	%>
     
	<%
		for (int i = list.size() - 1; i >= 0; i--) {
			//注意list是从0开始的 ,如果是正序的话,下标号是0--list.size()-1;
			//如果是逆序的话,下标号变为list.size()-1到0.
			//注意for循环的条件
	%>
	<div class="all">
		<a class="a" href="${pageContext.request.contextPath }/IdServlet?id=<%=list.get(i).getId()%>"><%=list.get(i).getTitle() %></a>
		<div>
			<p><%=list.get(i).getMessage()%></p>
		</div>
		<div align="right">
			<sub class="name"><%=list.get(i).getName()%></sub><sub><%=list.get(i).getTime()%></sub>
		</div>

	</div>

	<%
		}
	%>
</body>
</html>