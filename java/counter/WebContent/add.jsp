<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>计算器</title>
</head>
<body bgcolor="#ffffc0">
<h1>算术计算器</h1>
<form id="calcForm" method="post" action="add.action">
<table>
<tbody>
<tr>
<td>第一个数</td>
<td><input type="text" name="num1"></td>
</tr>

<tr>
<td>第二个数</td>
<td><input type="text" name="num2"></td>
</tr>

<tr>
<td><input type="submit" value="加"></td>
</tr>
</tbody>
</table>
</form>

</body>
</html>