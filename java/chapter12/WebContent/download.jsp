<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件下载</title>
</head>
<body>
<a href="/chapter12/DownloadServlet?filename=<%=URLEncoder.encode("风景.jpg","utf-8")%>">文件下载</a>
</body>
</html>