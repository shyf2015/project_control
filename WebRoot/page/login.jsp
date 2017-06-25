<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/all.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	
	<style>
		*{color:black !important;
		font-weight:bold !important;}
	</style>
  </head>
  
  <body>
    	<div class="login">
    		<form action="UserServlet">
    			<input type="hidden" name="method" value="login" />
    			<div id="ajaxyanzheng" class="font">
    					
    			</div>
    			<div class="username">
    				用户名<input type="text" name="uname"/>
    			</div>
    			<div class="_username font">
    				
    			</div>
    			<div class="password">
    				密码&nbsp<input type="password" name="password"/>
    			</div>
    			<div class="_password font">
    				
    			</div>
    			<div class="submit">
    				<input type="button" class="queren" value="确认"/>
    				<a href="page/zhuce.jsp"><input type="button" value="注册"/></a>
    			</div>
    		</form>
    	</div>
   <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
   <script>
   		$(".queren").on("click",function(){
   			if($(".username input").val()==null||$(".username input").val()==""){
   				$("._username").html("<i>用户名不能为空</i>");
   				return;
   			}
   			if($(".password input").val()==null||$(".password input").val()==""){
   				$("._password").html("<i>密码不能为空</i>");
   				return;
   			}
   			var username = $(".username input").val();
   			var password = $(".password input").val();
   			$.ajax({
   				url:"UserServlet",
   				type:"post",
   				data:{method:"ishas",username:username,password:password},
   				dataType:"text",
   				success:function(text){
   					if(text=="has"){
   						$("#ajaxyanzheng").html("<i>用户名或密码不正确</i>");
   					}else{
   						$("form").trigger("submit");
   					}
   				}
   			});
   		});
   		$("input").on("focus",function(){
   			$(this).parent().next().html("");
   		});
   		
   </script>
  </body>
</html>
