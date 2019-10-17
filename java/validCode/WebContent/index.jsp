<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(function(){
	$("a").click(function(){
		//浏览器带有缓存功能,不会多次请求相同数据
		$("img").attr("src","ValidCodeServlet?date="+new Date());
		return false;
	})
}
</script>
</head>
<body>
${error}
	<form action="LoginServlet" method="post">
		用户名：<input type="text" name="username"><br/>
		密码：<input type="password" name="password"><br/>
		验证码：<input type="text" name="code" size="1"><img  src="ValidCodeServlet" width="80" height="40"><a href="">看不清</a><br/>
		<input type="submit" value="登录"><input type="reset" value="重置">
	</form>
</body>
</html>