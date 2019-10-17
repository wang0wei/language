<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.Userdao.UserDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
ul li {
	list-style: none;
}

span {
	font-size: 13px;
}
</style>
<title>用户注册</title>
</head>
<body>
	<div
		style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
		<h1>注册界面</h1>
		<form action="RegisterServlet" method="post"
			onsubmit="return checkAll()">
			<!-- 表单提交的时候会触发onsubmit事件，如果onsubmit事件的方法返回是true，那么该表单允许提交，如果是false，该表单不允许提交。 -->
			<ul>

				<li>手机号： <input type="text" id="id" name="id" maxlength="11"
					onblur="checkId()" onfocus="checkid()">
					<div id="idclass"></div> <span id="idspan"></span>
				</li>


				<li>用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="name" name="name"
					maxlength="15" onblur="checkName()" onfocus="checkname()">
					<div id="nameclass"></div> <span id="namespan"></span>
				</li>


				<li>密&nbsp;&nbsp;&nbsp;码: &nbsp;&nbsp;&nbsp;<input type="password" id="password"
					name="password" maxlength="16" onblur="checkPassword()"
					onfocus="checkpassword()">
					<div id="passwordclass"></div> <span id="passwordspan"></span>
				</li>

				<li>确认密码:<input type="password" id="password1" name="password1"
					maxlength="16" onblur="checkPassword1()">
					<div id="passwordclass1"></div> <span id="passwordspan1"></span>
				</li>

			</ul>
			<input type="submit" value="注册"> <input type="reset"
				value="重置">
		</form>
	</div>
	<script type="text/javascript">
		function checkid() {
			var id = document.getElementById("id").value;
			var spanNode = document.getElementById("idspan");
			spanNode.innerHTML = "请输出11位手机号".fontcolor("red");
		}
		function checkname() {
			var id = document.getElementById("name").value;
			var spanNode = document.getElementById("namespan");
			spanNode.innerHTML = "昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号"
					.fontcolor("red");
		}
		function checkpassword() {
			var id = document.getElementById("password").value;
			var spanNode = document.getElementById("passwordspan");
			spanNode.innerHTML = "密码的长度为 6-16，包含任意的字母、数字，不可以使用其他符号"
					.fontcolor("red");
		}
		//检查手机号
		function checkId() {
			var id = document.getElementById("id").value;
			var spanNode = document.getElementById("idspan");
			//手机的规则:手机号长度为11位数字
			if (id && id.length == 11) {
				spanNode.innerHTML = "".fontcolor("green");
				document.getElementById("idclass").className = "icon ticker";
				return true;
			} else {
				//不符合规则  
				spanNode.innerHTML = "手机号输入错误".fontcolor("red");
				document.getElementById("idclass").className = "icon into";
				return false;
			}
		}
		//检查姓名
		function checkName() {
			var name = document.getElementById("name").value;
			var spanNode = document.getElementById("namespan");
			//用户名的规则： 昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号
			var reg = /^([\u4e00-\u9fa5]|[a-zA-Z0-9]){1,15}$/i;
			if (reg.test(name)) {
				//符合规则  
				spanNode.innerHTML = "".fontcolor("green");
				document.getElementById("nameclass").className = "icon ticker";
				return true;
			} else {
				//不符合规则  
				spanNode.innerHTML = "昵称不符合要求".fontcolor("red");
				document.getElementById("nameclass").className = "icon into";
				return false;
			}
		}
		//检查密码
		function checkPassword() {
			var password = document.getElementById("password").value;
			var spanNode = document.getElementById("passwordspan");
			//密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
			var reg = /^([a-zA-Z0-9]){6,16}$/i;
			if (reg.test(password)) {
				//符合规则  
				spanNode.innerHTML = "".fontcolor("green");
				document.getElementById("passwordclass").className = "icon ticker";
				return true;
			} else {
				//不符合规则  
				spanNode.innerHTML = "密码不符合要求".fontcolor("red");
				document.getElementById("passwordclass").className = "icon into";
				return false;
			}
		}
		//确认密码
		function checkPassword1() {
			var password = document.getElementById("password").value;
			var password1 = document.getElementById("password1").value;
			if(password!=password1){
				var spanNode = document.getElementById("passwordspan1");
				spanNode.innerHTML = "密码不一致".fontcolor("red");
				return false;
			}else{
				var spanNode = document.getElementById("passwordspan1");
				spanNode.innerHTML = "".fontcolor("red");
				return true;
			}

		}
		//6.检查用户所有的输入的所有是否符合规则
		function checkAll() {

			var name = checkName();
			var id = checkId();
			var password = checkPassword();
			var password1=checkPassword1();

			if (name && id && password&&password1) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>