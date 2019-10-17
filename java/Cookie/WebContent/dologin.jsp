<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
</head>
<body>
	<h2>登录成功</h2>
	<br>
	<br>
	<br>
	<br>
	<%
		request.setCharacterEncoding("utf-8");
		//首先判断用户是否选择了记住登录状态
		String[] isUseCookies = request.getParameterValues("isUseCookie");
		if (isUseCookies != null && isUseCookies.length > 0) {
			//把用户名和密码保存在cookie对象里面
			String username = URLEncoder.encode(request.getParameter("name"), "utf-8");
			//使用URLEncoder解决无法在cookie当中保存中文字符串问题
			String password = URLEncoder.encode(request.getParameter("password"), "utf-8");

			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
			usernameCookie.setMaxAge(864000);//设置最大生存期限为10天
			passwordCookie.setMaxAge(864000);
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
		} else {//如果没有勾选，将原来cookie里保存的数据清空
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {//如果之前保存了
				for (Cookie c : cookies) {
					if (c.getName().equals("username") || c.getName().equals("password")) {
						c.setMaxAge(0);//设置cookie失效
						response.addCookie(c);//重新保存
					}
				}
			}
		}
	%>
	<a href="user.jsp" target="_blank">查看用户信息</a>
</body>
</html>