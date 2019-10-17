<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 导包 -->
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>了解JSP页面的基本构成</title>
</head>
<body>
<%
Date date=new Date();//获取日期对象
//设置日期时间格式
SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String today=df.format(date);//获取当前系统日期
%>
<!-- 输出系统时间 -->
当前时间:<%=today %>    
<br>
<%--哈哈哈 --%>
<h2>out内置对象</h2>
<%
out.println("<h3>静夜思</h3>");
out.println("床前明月光<br>");
out.println("疑是地上霜<br>");
out.println("举头望明月<br>");
out.println("低头思故乡<br>");
%>
<br><br>
缓冲区大小:<%=out.getBufferSize() %>byte<br>
缓冲区剩余大小:<%=out.getRemaining() %>byte<br>
是否自动清空缓冲区:<%=out.isAutoFlush() %>&nbsp;&nbsp;&nbsp;boolean<br>
<%out.write("我喜欢你");  %>

</body>
</html>