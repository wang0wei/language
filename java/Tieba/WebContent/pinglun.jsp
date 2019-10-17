<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.DB.DBconn" import="java.util.ArrayList"
	import="com.entity.Message" import="java.sql.ResultSet" import="com.entity.Pinglun"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>评论</title>
<style type="text/css">
.name {
	margin-right: 10px;
	
}

.a {
	width: text-decoration:none;
	align: center;
	margin-top: 50px;
	color: blue;
}
</style>
<script>
	function checkText() {
		var flag = true;
		var text = document.getElementById("pinglun").value;
		if ("" == text) {
			alert("请输入留言内容！");
			flag = false;
		}
		return flag;
	}
</script>
</head>
<body>

	<%
	    String id = (String) session.getAttribute("id");//获取session里面的id值
		String sql = "select * from message where id='" + id + "'";
		ArrayList<Message> list = new ArrayList<Message>();
		list = DBconn.getMessageList(sql);//将数据库里面的所有信息存到list中
		for (int i = list.size() - 1; i >= 0; i--) {
	%>
	<div
		style="text-align: center; margin-top: 60px; margin-left: 10%; margin-right: 10%;background-color:#f0f0f0;border-radius:10px">

		<h3 class="a"><%=list.get(i).getTitle()%></h3>
		<div>
			<sub class="name">作者:<%=list.get(i).getName()%></sub> <sub>时间:<%=list.get(i).getTime()%></sub>
		</div>

		<div>
			<p style="text-align:left"><%=list.get(i).getMessage()%></p>
		</div>
	</div>
	<%
			
	}
	
		%>
	<form action="PinglunServlet" method="post"
		onsubmit="return checkText()" >
		<div align="center">
			<textarea id="pinglun" name="pinglun" placeholder="请填写评论"
				style="width: 60%; height: 90px"></textarea>
		</div>
		<input type="submit" value="立即评论" style="float: right">
	</form>

<%
		String sql1 = "select * from pinglun where whos='"+id+"'";
         ArrayList<Pinglun> list1 = new ArrayList<Pinglun>();
		list1= DBconn.getPinglunList(sql1);
		for (int i = list1.size() - 1; i >= 0; i--) {
	%>
	<div
		style="text-align: center; margin-top: 60px; margin-left: 10%; margin-right: 10%;background-color:#EBD3E8;border-radius:10px">
		<div>
			<p style="text-align: left"><%=list1.get(i).getPmessage()%></p>
		</div>
		<div align="right">
			<sub class="name"><%=list1.get(i).getPname()%></sub> <sub><%=list1.get(i).getPtime()%></sub>
		</div>


	</div>


	<%
		}
	%>

</body>
</html>