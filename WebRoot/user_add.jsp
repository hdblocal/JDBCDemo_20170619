<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <center>
      <h1><font color="red">用户管理系统</font></h1>
		<h5>20170619</h5>
      	<form action="<%=basePath %>/UserAddServlet" method="post">
	      	<table>
	      		<tr>
		      		<td>用户名</td>
		      		<td><input type="text" name="username"/></td>
		      	</tr>
	      		<tr>
	      			<td>密码</td>
	      			<td><input type="password" name="password"/></td>
	      		</tr>
	      		<tr>
	      			<td colspan="2">
	      				<input type="submit" value="提交"/>
	      			</td>
	      		</tr>
      	</table>
      	</form>
      </center>
  </body>
</html>
