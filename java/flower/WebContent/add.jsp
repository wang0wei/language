<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="InsertServlet" method="post">
		<table style="border:1px; align:center;">

			<tr>
				<td colspan="2"
					style="text-align: center; font-size: 30px; font-weight: bold;">
					花卉信息：</td>
			</tr>

			<tr>
				<td><b>花卉名称：</b></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><b>花卉价格：</b></td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td><b>原产地：</b></td>
				<td><input type="text" name="production"></td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="提交"><input type="reset" value="重置">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>