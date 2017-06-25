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
    
    <title>My JSP 'chat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		.chat_info li{
			padding:8px;
			margin:8px;
			border-radius:5px;
		}
		.chat_info li.you{
			background:#aff;
		}
		.chat_info li.me{
			background:#faf;
		}
		*{color:black !important;
		font-weight:bold !important;}
	</style>
  </head>
  	
  <body style="background:#eef">
    <div class="container">
    	<div class="row">
    		<a href="MainServlet"><button class="btn">返回首页</button></a>
	    	<h1 style="padding-left:50px">${xiangmu2 }的聊天室</h1>
    	</div>
    	<div class="col-sm-3">
    		<table style="text-align:center" class="table table-bordered table-striped">
    			<tr><th>在线用户:</th></tr>
    			<c:forEach items="${online_users }" var="s">
    				<tr><td><a class='user'>${s }</a></td></tr>
    			</c:forEach>
    		</table>
    	</div>
    	<div style="display:none" class="chat col-sm-9">
    		<div style="padding:0;border:2px solid #aae;height:400px;" class="col-sm-12">
    			<div style="background:#bbf;height:30px;text-align:center;" class="col-sm-12 head">$yyy</div>
    			<ul class="chat_info col-sm-12" style="height:370px;list-style:none;overflow:auto">
    				<c:forEach items="${chats }" var="chat">
    					<li class='<c:if test="${chat.send == xiangmu2 }">me</c:if><c:if test="${chat.send == recive }">you</c:if>'>${chat.send }:${chat.content }</li>
    				</c:forEach>
    			</ul>
    		</div>
    		<div style="border:2px solid #aae;height:120px;padding:0" class="col-sm-12">
    		<form class="form" action="ChatServlet">
    			<input type="hidden" name="method" value="add"/>
    			<textarea rows="4" class="col-sm-12" name="content" style="resize:none;"></textarea>
    			<input type="hidden" name="send" value="${xiangmu2 }"/>
    			<input class="recive" type="hidden" name="recive" value=""/>
    			<input class="btn fasong" type="button" value="发送">
    			<a href="ChatServlet?method=list&recive=${recive }&send=${xiangmu2 }"><input class="btn" type="button" value="刷新"></a>
    			<input class="btn exit" type="button" value="退出">
    			<input class="btn history" type="button" value="历史记录">
    			
    		</form>
    		<form class="form2" action="ChatServlet">
    			<input type="hidden" name="method" value="list">
    			<input type="hidden" name="send" value="${xiangmu2 }">
    			<input class="recive2" type="hidden" name="recive" value="">
    		</form>
    		<form class="form3" action="ChatServlet">
    			<input type="hidden" name="method" value="allList">
    			<input type="hidden" name="send" value="${xiangmu2 }">
    			<input class="recive3" type="hidden" name="recive" value="">
    		</form>
    		</div>
    	</div>
    </div>
   <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script>
    	<% if(request.getAttribute("recive")!=null){%>
    		$(".head").html("<%=request.getAttribute("recive")%>");
    		$(".chat").show();
    		//setTimeout(shuaxin, 1000);
    	<%}%>
    	//打开聊天对象
    	$(".user").bind("click",function(){
    		$(".head").html($(this).html());
    		$(".chat").show();
    		$(".recive2").val($(".head").html());
    		$(".form2").trigger("submit");
    	});
    	//实时更新
    	/* function shuaxin(){
    		$(".form2").trigger("submit");
    	} */
    	//退出聊天窗口
    	$(".exit").bind("click",function(){
    		$(".chat").hide();
    	});
    	//发送消息
    	$(".fasong").bind("click",function(){
    		$(".recive").val($(".head").html());
    		$(".form").trigger("submit");
    	});
    	$(".history").bind("click",function(){
    		$(".recive3").val($(".head").html());
    		$(".form3").trigger("submit");
    	});
    </script>
  </body>
</html>
