<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"  %>
<%@ page import="com.suncn.vo.User"  %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<User> userlist = (List<User>)request.getAttribute("userlist") ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1><font color="red">用户管理系统</font></h1>
		<h5>20170619</h5>
		<table border="1" cellpadding="1" cellspacing="1" width="60%">
			<tr>	
				<td colspan="5" style="text-align:right">
					<a href="<%=basePath %>/user_add.jsp"><font color="red">增加用户</font></a>
				</td>
			</tr>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>密码</th>
				<th>创建日期</th>
				<th>操作</th>
			</tr>
			<%if(userlist==null) {%>
				<tr>
					<td colspan="4"><h3><font>暂时没有任何数据</font></h3></td>				
				</tr>				
			<%}else{
			     for(User user:userlist){%>
				<tr>
					<td><%=user.getId() %></td>
					<td><%=user.getName() %></td>
					<td><%=user.getPassword() %></td>
					<td><%=user.getCreateTime() %></td>
					<td><a href="<%=basePath %>/UserDeleteServlet?id=<%=user.getId() %>">删除</a>
						<a href="#">修改</a>
					</td>
				</tr>
			<%} 
			}%>
		</table>
	</center>
</body>
</html>