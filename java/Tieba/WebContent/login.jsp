<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>

	<div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
     <h1>登录界面</h1>
     <form action="LoginServlet" method="post">
       <table>
         <tr>
            <td>账号:</td>
            <td><input name="name" type="text"></td>
         </tr>
         <tr>
            <td>密码:</td>
            <td ><input name="password" type="password"></td>
         </tr>
       </table>
       <input type="submit"  value="登录" style="font-size: 16px"> 
       &nbsp;&nbsp;<a href="register.jsp" style="text-decoration:none">注册</a>
     </form>
  </div>

</body>
</html>