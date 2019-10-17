<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
nav {
	width: 100%;
	height: 40px;
	text-align: center;
	background-color: #e0e0e0;
	border-radius:25px;
}

ul {
	height: 40px;
	line-height: 40px;
}

li {
	height: 40px;
	line-height: 40px;
	display: inline;
}

a {
	text-decoration: none;
	color: black;
}

ul li:nth-child(1) {
	text-align: center;
	float: left;
}

ul li:nth-child(2) {
	float: left;
}

ul li:nth-child(3) {
	float: right;
}

.class1 {
	height: 40px;
	padding-right: 50px
}

ul li a:hover {
	color: blue;
}
</style>
<nav>
	<ul>
		<li><span class="class1"><a href="index.jsp">首页</a></span></li>
		<li><a href="${pageContext.request.contextPath}/IsLoginServlet"  >发帖</a></li>
		
		<li><span class="class1">
		<c:choose>
		<c:when test="${sessionScope.name==null }">
		<a href="login.jsp">登录</a>
		</c:when>
		<c:otherwise>
		${sessionScope.name }&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
		</c:otherwise>
		</c:choose>
		</span></li>
		
		<li><input type="text" style="border:none;height:20px;border-radius:5px;"><input type="button" value="搜索" style="border:1px solid #3c3c3c;border-radius:5px;"></li>

	</ul>
</nav>