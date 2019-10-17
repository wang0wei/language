<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用声明标识</title>
</head>
<body>
<%!
int count=0;
public int getCount(){
	count++;
	return count;
}
%>
<p>您好,您是本站的第<%=getCount() %>位来访者!</p>
</body>
</html>