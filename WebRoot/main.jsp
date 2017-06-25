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
    
    <title>项目管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/all.css">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<style>
		*{color:black !important;
		font-weight:bold !important;}
	</style>

  </head>
  
  <body>
  <div class="container2">
    <div class="nav">
    	<div class="logo"><img src="image/logo.jpg" alt="logo"/></div>
    	<div class="left">
    		<ul>
    			<li><a class="my" href="ProjectServlet?method=list&uid=${user.uid }">我的项目</a></li>
    			<li class="create_pro"><a>创建项目</a></li>
    			<li><a class="chat" href="page/chat.jsp">私信</a></li>
    		</ul>
    	</div>
    	<div class="right">
    	<c:if test="${empty user }">
    		<ul>
    			<li><a href="page/login.jsp">登录</a></li>
    		</ul>    	
    	</c:if>
    	<c:if test="${not empty user }">
    		<ul class="set">
    			<li><a>${user.uname }</a><p>&lt</p></li>
    			<li><a>个人中心</a></li>
    			<li><a>设置密码</a></li>
    			<li><a>退出</a></li>
    		</ul>
    	</c:if>
    	</div>
    <div class="create" id="create">
  		<p class="exit">×</p>
  		
  		<form class="new_pro" action="ProjectServlet">
  			<input type="hidden" name="method" value="add" />
  			<input type="hidden" name="uname" value="${user.uname }" />
  			<input type="hidden" name="uid" value="${user.uid }" />
  			<div class="pname">项目名称<input type="text" name="pname"/></div>
  			<div class="_pname font"></div>
  			<div class="description">项目描述<input type="description" name="description"/></div>
  			<div class="_description font"></div>
  			<div class="manager">负责人&nbsp<input type="text" name="manager"/></div>
  			<div class="_manager font"></div>
  			<div class="queren"><input type="button" class="queren" value="创建"></div>
   		</form>
    </div>
  
  </div>
  <div style="position:fixed;" id="myCarousel" class="carousel slide">
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
	</ol>   
	<div class="carousel-inner">
		<div class="item active">
			<img src="img/1.png" alt="First slide">
		</div>
		<div class="item">
			<img src="img/2.png" alt="Second slide">
		</div>
		<div class="item">
			<img src="img/3.png" alt="Third slide">
		</div>
		<div class="item">
			<img src="img/4.png" alt="Third slide">
		</div>
	</div>
	<a class="carousel-control left" href="#myCarousel" 
	   data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" 
	   data-slide="next">&rsaquo;</a>
</div>
</div>
  <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script>
  	function empty(){
  		$(".new_pro .font").html("");
  	}
  	$(".new_pro input").on("focus",empty);
  	$(".queren").on("click",function(){
  		if($(".pname input").val()==""||$(".pname input").val()==null){
   				$("._pname").html("<i>不能为空</i>");
   				return;
   			}
   			
   			if($(".description input").val()==""||$(".description input").val()==null){
   				$("._description").html("<i>不能为空</i>");
   				return;
   			}
   			if($(".manager input").val()==""||$(".manager input").val()==null){
   				$("._manager").html("<i>不能为空</i>");
   				return;
   			}
   			$(".new_pro").trigger("submit");
  	});
  	$(".exit").on("click",function(){
  		$(".create").css({display:"none"});
  	});
  	$(".my,.chat").on("click",function(){
  		<% if(request.getAttribute("user")==null){%>
  			alert("你还没有登录");
  			return false;
  		<%}else{%>
  			
  		<%}%>
  	});
  	$(".create_pro").on("click",function(){
  		<% if(request.getAttribute("user")==null){%>
  			alert("你还没有登录");
  			return;
  		<%}else{%>
  			$(".create").css({display:"block"});
  		<%}%>
  	});
  </script>
  </body>
</html>
