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
    
    <title>My JSP 'zhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/all.css">
	<link rel="stylesheet" type="text/css" href="css/zhuce.css">
	<style>
		*{color:black !important;
		font-weight:bold !important;}
	</style>
  </head>
  
  <body>
    <div class="zhuce">
    	<form action="UserServlet">
    		<input type="hidden" name="method" value="add" />
    		<div id="ajaxyanzheng" class="error font">
    			
    		</div>
    		<div class="username">
    			用户名<input id="username" type="text" name="uname"/>
    		</div>
    		<div class="_username font">
    			
    		</div>
    		<div class="password">
    			密码&nbsp<input type="password" name="password"/>
    		</div>
    		<div class="_password font">
    			
    		</div>
    		<div class="phone">
    			手机号<input type="text" name="phone"/>
    		</div>
    		<div class="_phone font">
    			
    		</div>
    		<div class="email">
    			邮箱&nbsp<input type="text" name="email"/>
    		</div>
    		<div class="_email font">
    			
    		</div>
    		<div class="submit">
    			<input type="button" class="queren" value="确认"/>
    			<input type="reset" value="重置"/>
    		</div>
    		
    	</form>
    </div>
   <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
   <script>
   		var email_reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
   		var phone_reg = /^1[3|4|5|8][0-9]\d{4,8}$/;
   		var username_reg = /^[\w]{4,8}$/;
   		var password_reg = /^[\d]{8}/;
   		$(".queren").on("click",function(){
   			if($(".username input").val()==""||$(".username input").val()==null){
   				$("._username").html("<i>不能为空</i>");
   				return;
   			}
   			if(!username_reg.test($(".username input").val())){
   				$("._username").html("<i>用户名只能由4到8位字符组成</i>");
   				return;
   			}
   			if($(".password input").val()==""||$(".password input").val()==null){
   				$("._password").html("<i>不能为空</i>");
   				return;
   			}
   			if(!password_reg.test($(".password input").val())){
   				$("._password").html("<i>密码只能由8位数字组成</i>");
   				return;
   			}
   			if($(".phone input").val()==""||$(".phone input").val()==null){
   				$("._phone").html("<i>不能为空</i>");
   				return;
   			}
   			if(!phone_reg.test($(".phone input").val())){
   				$("._phone").html("<i>手机号格式不正确</i>");
   				return;
   			}
   			if($(".email input").val()==""||$(".email input").val()==null){
   				$("._email").html("<i>不能为空</i>");
   				return;
   			}
   			if(!email_reg.test($(".email input").val())){
   				$("._email").html("<i>邮箱格式不正确</i>");
   				return;
   			}
   			$("form").trigger("submit");
   		});
   		$("input").on("focus",function(){
   			$(this).parent().next().html("");
   			$("#ajaxyanzheng").html("");
   		});
   		
   		$("#username").on("blur",function(){
   			var username = $(".username input").val();
   			$.ajax({
   			url:"UserServlet",
   			type:"post",
   			data:{method:"ishas",username:username},
   			dataType:"text",
   			success:function(t){
   				alert(t);
   				if(text=="no"){
   					$("#ajaxyanzheng").html("<i style='color:red'>此用户已经存在</i>");
   				}else{
   					$("#ajaxyanzheng").html("<span style='color:green;'>有效的用户</span>");
   				}
   			}
   		});
   	});
   </script>
  </body>
</html>
