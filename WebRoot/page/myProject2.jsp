<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'myProject2.jsp' starting page</title>
    
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
		ul.nav-tabs{
        width: 140px;
        margin-top: 20px;
        border-radius: 4px;
        border: 1px solid #ddd;
        box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
    }
    ul.nav-tabs li{
        margin: 0;
        border-top: 1px solid #ddd;
    }
    ul.nav-tabs li:first-child{
        border-top: none;
    }
    ul.nav-tabs li a{
        margin: 0;
        padding: 8px 16px;
        border-radius: 0;
    }
    ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover{
        color: #fff;
        background: #0088cc;
        border: 1px solid #0088cc;
    }
    ul.nav-tabs li:first-child a{
        border-radius: 4px 4px 0 0;
    }
    ul.nav-tabs li:last-child a{
        border-radius: 0 0 4px 4px;
    }
    ul.nav-tabs.affix{
        top: 30px; /* Set the top position of pinned element */
    }
	</style>
  </head>
  
  <body data-spy="scroll" data-target="#myScrollspy">
    <div class="container">
   <div class="jumbotron">
        <h1>${infos[0].pname }</h1>
    </div>
    <div class="row">
        <div class="col-xs-3" id="myScrollspy">
        <a href="MainServlet"><button class="btn">返回首页</button></a>
        <a href="MyprojectServlet?uid=${infos[0].uid}"><button class="btn">返回上一页</button></a>
            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125">
                <li><a href="#section-1">项目基本信息</a></li>
                <li><a href="#section-2">项目计划</a></li>
                <li><a href="#section-3">项目进度</a></li>
                <li><a href="#section-4">项目记录</a></li>
                <li><a href="#section-5">项目总结</a></li>
            </ul>
        </div>
        <div class="col-xs-9">
            <h2 id="section-1">项目基本信息</h2>
            <form role="form" action="ProjectServlet" method="get">
            <input type="hidden" name="method" value="updata" />
            <input type="hidden" name="pid" value="${infos[0].pid }" />
    		<div class="form-group">
        		<label for="name">项目名称</label>
        		<input type="text" name="pname" class="form-control" id="name" value="${infos[0].pname }">
    		</div>
    		<div class="form-group">
        		<label for="name">项目负责人</label>
        		<input type="text" name="manager" class="form-control" id="name" value="${infos[0].manager }">
    		</div>
    		<div class="form-group">
        		<label for="name">项目创建日期</label>
        		<input type="text" name="createTime" disabled="disabled" class="form-control" id="name" value="${infos[0].createTime }">
    		</div>
    		<div class="form-group">
        		<label for="name">项目简单的描述</label>
        		<input type="text" name="description" class="form-control" id="name" value="${infos[0].description }" >
    		</div>
    		<div class="form-group">
        		<label for="name">项目参与者</label>
        		<input type="text" name="parter" class="form-control" id="name" value="${infos[0].parter }">
    		</div>
    		<div class="form-group">
        		<label for="name">项目截止时间</label>
        		<input type="date" name="deadline" class="form-control" id="name" value="${infos[0].deadline }">
    		</div>
    		<div class="form-group">
						<input type="submit" class="btn" value="保存修改">
					</div>
			</form>
            <hr>
            <h2 id="section-2">项目计划</h2>
            <form action="PlanServlet">
            <table style="text-align:center"  class="shyf_plan table table-bordered table-striped">
            	<input type="hidden" name="method" value="add" />
            	<input type="hidden" name="pid" value="${infos[0].pid }" />
            	<tr><th>模块名称</th><th>模块简述(具体包括什么功能)</th><th>估算工时(hours)</th><th>操作</th></tr>
            	<c:forEach items="${infos[1] }" var="plan" varStatus="stu">
            		<tr>
            			<td>${plan.plname }</td>
            			<td>${plan.pdescription }</td>
            			<td>${plan.hours }</td>
            			<td><a href="PlanServlet?method=delete&pid=${infos[0].pid }&plid=${plan.plid } ">删除</a>|<a href="FunctionServlet?method=list&plid=${plan.plid }">进入</a></td>
            		</tr>
            	</c:forEach>
            </table>
            <div style="margin-left:400px;margin-top:-20px;cursor:pointer;width:50px;height:30px;text-align:center;line-height:30px;background:#999;color:white;font-size:25px;font-weight:bold;" class="addplan">+</div>
            <input type="submit" class="btn" value="保存修改"/>
            </form>
            <hr>
            <h2 id="section-3">项目进度</h2>
          	已使用时间:${process }
            <div class="progress">
    			<div class="progress-bar" role="progressbar" aria-valuenow="60" 
        			aria-valuemin="0" aria-valuemax="100" style="width:${process };">
        			<span class="sr-only">40% 完成</span>
    			</div>
			</div>
            <table style="text-align:center" class="table table-bordered table-striped">
            	<tr><th>模块名称</th><th>未完成功能</th><th>已完成功能</th></tr>
            	<c:forEach items="${infos[1] }" var="plan">
            		<tr><td>${plan.plname }</td><td>${map1[plan] }</td><td>${map2[plan] }</td></tr>
            	</c:forEach>
            </table>
            <hr>
            <h2 id="section-4">项目记录</h2>
            <form action="RecordServlet">
            	<input type="hidden" name="method" value="add" />
            	<input type="hidden" name="pid" value="${infos[0].pid }" />
            	<table style="text-align:center" class="shyf_record table table-bordered table-striped">
            	<tr><th>记录标题</th><th>记录内容</th><th>记录时间</th></tr>
            	<c:forEach items="${infos[2] }" var="record">
            		<tr>
            			<td>${record.title }</td>
            			<td>${record.content }</td>
            			<td>${record.time }</td>
            		</tr>
            	</c:forEach>
            </table>
            <div style="margin-left:400px;margin-top:-20px;cursor:pointer;width:50px;height:30px;text-align:center;line-height:30px;background:#999;color:white;font-size:25px;font-weight:bold;" class="addrecord">+</div>
           	<input type="submit" class="btn" value="保存修改"/>
           	</form>
            <hr>
            <h2 id="section-5">项目总结</h2>
            <h4>此功能尚在开发中</h4>
        </div>
    </div>
</div>
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(".addplan").on("click",function(){
		$(".shyf_plan").append("<tr><td><input type='text' required='required' name='plname'/></td><td><input type='text' required='required' name='pdescription'/></td><td><input type='text' required='required' name='hours'/></td><td><a onclick='del(this)'>删除</a></td></tr>");
	});
	$(".addrecord").on("click",function(){
		$(".shyf_record").append("<tr><td><input type='text' required='required' name='title'/></td><td><input type='text' required='required' name='content'/></td><td><a onclick='del(this)'>删除</a></td></tr>");
	});
	function del(obj){
		$(obj).parent().parent().remove();
	}

</script>
</body>
</html>
