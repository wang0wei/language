<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
<%String str = (String)request.getAttribute("id"); 
	  String name = (String)request.getAttribute("name");
	%>
 	<form action="UploadServlet?id=<%=str%>&name=<%=name%>" method="post" 
      enctype="multipart/form-data">
 		<table width="600px">
 			<tr>
 				<td>上传者</td>
 				<td><input type="text" name="name" /></td>
 			</tr>
 			<tr>
 				<td>上传文件</td>
 				<td><input type="file" name="myfile" /></td>
 			</tr>
 			<tr>
 				<td colspan="2"><input type="submit" value="上传" /></td>
 			</tr>
 		</table>
 	</form>
</body>
</html>