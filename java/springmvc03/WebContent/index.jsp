<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request:${requestScope.req }<br/>
	session:${sessionScope.session }<br/>
	sessionParam:${sessionScope.sessionParam }<br/>
	application:${applicationScope.application }<br/>
	map:${map }<br>
	model:${model }<br/>
	mav:${mav }
	
</body>
</html>