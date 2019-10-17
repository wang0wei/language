<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>作业上传系统</title>
  </head>
  <body >
         <form action="DengluServlet"  method="post"  style="padding-top:-700px;">
		用户名：<input type="text" name="name"value=""><br><br>
 		密码：  <input type="password" name="pwd"value=""><br><br>
	                <input type="submit"value="登录"name="denglu"><input type="reset"value="重置"><br>
	 </form>
    
  </body>
</html>
