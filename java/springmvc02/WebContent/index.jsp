<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="demo6" method="post">
		<!-- <input type="text" name="name">
		<input type="text" name="age">
		<input type="checkbox" name="hover" value="学习">
		<input type="checkbox" name="hover" value="写代码">
		<input type="checkbox" name="hover" value="看视频">
		<input type="checkbox" name="hover" value="看笔记"> -->
		<input type="text" name="peo[0].name">
		<input type="text" name="peo[0].age">
		<input type="text" name="peo[1].name">
		<input type="text" name="peo[1].age">
		<input type="submit" name="提交">
		
		<a href="demo7?age=123&name=abc">跳转</a>
		<a href="demo8/123/abc">跳转</a>
	</form>
</body>
</html>