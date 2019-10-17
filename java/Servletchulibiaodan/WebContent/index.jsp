<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>收集信息</title>

</head>
<body>
<form action="AddressServlet" method="post" onsubmit="return check(this);">
<h2>添加人员信息</h2>
<ul>
<li>姓名：<input type="text" name="name"></li>
<li>性别：
<input type="radio" name="sex" value="男" checked="checked">男
<input type="radio" name="sex" value="女" >女
</li>
<li>家庭住址：<textarea rows="5" cols="30" name="add"></textarea></li>
<li><input type="submit"  value="添加"></li>
</ul>
</form>
<script type="text/javascript">
function check(form){
	with(form){
		if(name.value==""){
			alert("姓名不能为空！ ");
			return false;
		}
		if(add.value==""){
			alert("家庭住址不能为空！ ");
			return false;
		}
	}
}
</script>
</body>
</html>
