<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
ul li{
list-style:none;
}
</style>
<title>留言</title>
</head>
<body>
<script type="text/javascript">
    	function checkTitle(){
    		var flag = true;
    		var title = document.getElementById("title").value;
			if ("" == title){
				alert("请输入标题！");
				flag = false;
			}
			return flag;
		}
    	function checkText(){
    		var flag=true;
    		var text=document.getElementById("text").value;
    		if ("" == text){
				alert("请输入留言内容！");
				flag = false;
			}
    		return flag;
    	}
    	 function checkAll(){  
    		          
    		          var title = checkTitle();  
    		          var text = checkText();    		         
    		          if(title&&text){  
    		              return true;  
    		          }else{  
    		              return false;  
    		          }  
    		      }
    </script>
 <div style="text-align: center; margin-top: 100px">
     <h1>请留言</h1>
     <form action="MessageServlet" method="post" onsubmit="return checkAll()">
       <ul>
           <li>
           <input type="text" id="title" name="title"  style="width:410px;height:20px;" placeholder="留言标题" /><br><br>
           </li>
      
         <li> 
         <textarea id="text" name="message" rows="10" cols="60"  placeholder="留言内容"></textarea><br><br>
         </li>
         
      </ul>
       <input type="submit"value="提交" />
       <input type="reset"value="重置" />
     </form>
  </div>
</body>
</html>
