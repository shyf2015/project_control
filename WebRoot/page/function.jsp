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
    
    <title>My JSP 'function.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" 

href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script 

src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>  
      .nav li a{
      	padding-left:30px;
      	padding-right:30px;
      	background:#999;
      	margin:5px;
      }
		*{color:black !important;
		font-weight:bold !important;}
    </style>  

  </head>
  
  <body style="background:#ccf">
    <div class="container">
    	<div class="jumbotron" style="padding-top:20px;padding-bottom:20px">${plan.plname }模块</div>
    	<a href="MainServlet"><button class="btn">返回首页</button></a>
        <a href="ProjectServlet?method=query&pid=${plan.pid }"><button class="btn">返回上一页</button></a>
    	<form style="display:inline-block" action="FunctionServlet">
    	<input type="hidden" name="plid" value="${plan.plid }"/>
    	<input type="hidden" name="method" value="add"/>
    	<input type="submit" class="btn" value="新增功能">
    	<input class="btn" type="text" placeholder="请写下新功能名称" required="required" name="fname"/>
    	</form>
    	<a onclick="return confirm('确定删除')" href="FunctionServlet?method=delete&plid=${plan.plid }&fid=${function.fid}"><button class="btn">删除当前功能:${function.fname }</button></a>
    	<button class="btn save">保存功能</button>
        <br><br>
        
    	<nav class="nav navbar-nav navbar-default">
    		<c:forEach items="${functions }" var="f">
    			<li class="active"><a href="FunctionServlet?method=query&fid=${f.fid }&plid=${plan.plid }">${f.fname }</a></li>
    		</c:forEach>
    	</nav>
    
    </div>
    	<div class="container">
        	<form action="FunctionServlet">
        	<input type="hidden" name="method" value="updata">
        	<input type="hidden" name="plid" value="${plan.plid }">
        	<input type="hidden" name="fname" value="${function.fname }">
        	<input type="hidden" name="fid" value="${function.fid }">
        	<div class="col-sm-4">
        		<div style="margin:20px">
        			<h3>完成情况</h3>
        			<c:if test="${function.state==1 }">
        				<input type="radio" name="state" checked="checked" value="1"/> 未开始
        			</c:if>
        			<c:if test="${function.state!=1 }">
        				<input type="radio" name="state" value="1"/> 未开始
        			</c:if>
        			<c:if test="${function.state==2 }">
        				<input type="radio" name="state" checked="checked" value="2"/> 开发中
        			</c:if>
        			<c:if test="${function.state!=2 }">
        				<input type="radio" name="state" value="2"/> 开发中
        			</c:if>
        			<c:if test="${function.state==3 }">
        				<input type="radio" name="state" checked="checked" value="3"/> 已完成
        			</c:if>
        			<c:if test="${function.state!=3 }">
        				<input type="radio" name="state" value="3"/> 已完成
        			</c:if>
        		</div>
        		<div class="col-sm-12" style="padding:20px">
        			<h3>功能概述</h3>
        			<textarea class="col-sm-12" name="fdescription" style="height:200px;resize:none">${function.fdescription }</textarea>
        		</div>
        		
        	</div>
        	<div class="col-sm-8">
        		<h3>详细代码</h3>
        		<textarea name="code" class="col-sm-12" style="height:320px;resize:none">${function.code }</textarea>
        	</div>
        	</form>
    	</div>
      
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script>
  	$(".save").bind("click",function(){
  		$("form").trigger("submit");
  	});
  </script>
  </body>
</html>
