<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

请求URI为:${pageContext.request.requestURI }<br>
Content-Type响应头:${pageContext.response.contentType }<br>
服务器信息为:${pageContext.servletContext.serverInfo }<br>
Servlet注册名为:${pageContext.servletConfig.servletName }<br>
</body>
</html>