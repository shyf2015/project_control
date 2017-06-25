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
    
    <title>My JSP 'myProject.jsp' starting page</title>
    
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
		*{color:black !important;
		font-weight:bold !important;}
	</style>
  </head>
  
  <body>
  <div class="container">

  	<a href="MainServlet"><button class="btn">返回首页</button></a>
  	<form class="pull-right" style="display:inline-block">
  		<input type="hidden" name="method" value="search" />
  		<input type="hidden" name="uid" value="${xiangmu }" />
  		<input name="sousuo" type="text" required="required" />
  		<input type="submit" class="btn" value="搜索"/>
  	</form>
  	<c:if test="${empty projects }">
  		<h1>你还没有任何项目，快去创建一个</h1>
  	</c:if>
  	<c:if test="${not empty projects }">
	    <table style="text-align:center" class="table table-bordered table-striped">
	    	<tr><th>序号</th><th>项目名称</th><th>项目负责人</th><th>项目创建日期</th><th>项目详情</th><th>操作</th></tr>
	    	<c:forEach items="${projects }" var="project" varStatus="s">
	    		<tr>
	    			<td>${s.count }</td>
	    			<td>${project.pname }</td>
	    			<td>${project.manager }</td>
	    			<td>${project.createTime }</td>
	    			<td><a href="ProjectServlet?method=query&pid=${project.pid }">进入</a></td>
	    			<td><a href="ProjectServlet?method=delete&uid=${project.uid }&pid=${project.pid }" onclick="return confirm('你确定删除?');">删除</a></td>
	    		</tr>
	    	</c:forEach>
	    </table>
  	</c:if>
    </div>
  </body>
</html>
