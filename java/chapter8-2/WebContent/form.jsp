<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body style="text-align: center;">
	<h3>用户登录</h3>
	<a
		href="<%=request.getContextPath()%>/CharacterServlet?name=传智播客&password=123456">单击超链接登录
	</a>

	<form action="<%=request.getContextPath()%>/CharacterServlet"
		method="post">
		<table
			style="border: 1px; width: 600px; cellpadding: 0; cellspacing: 0; align: center;">
			<tr>
				<td style="height: 30px; align: center;">用户名:</td>
				<td>&nbsp;<input type="text" name="name"></td>
			</tr>

			<tr>
				<td style="height: 30px; align: center;">密&nbsp;码:</td>
				<td>&nbsp;<input type="password" name="password"></td>
			</tr>
			<tr>
				<td style="height: 30px; colspan: 2; align: center"><input
					type="submit" value="登录">&nbsp;&nbsp;&nbsp;<input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>