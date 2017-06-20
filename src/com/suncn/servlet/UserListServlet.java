package com.suncn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suncn.util.JdbcUtil;
import com.suncn.vo.User;


public class UserListServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Connection conn = JdbcUtil.getConnection() ;
    	JdbcUtil.beginTransaction(conn) ;
    	
    	//==============================================================================
    	String sql = "select u.id,u.username,u.password,u.createTime from tb_user u" ;
    	ResultSet rs = null;
    	List<User> list = new LinkedList<User>() ;
		try {
			rs = conn.createStatement().executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					User user = new User() ;
					user.setId(rs.getInt(1)) ;
					user.setName(rs.getString(2)) ;
					user.setPassword(rs.getString(3)) ;
					user.setCreateTime(rs.getDate(4)) ;
					list.add(user) ;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		//==============================================================================
    	JdbcUtil.commitTransaction(conn) ;
    	//关闭数据库连接,让其他操作来进行连接
    	JdbcUtil.close(rs, conn) ;
    	
    	//把用户列表放到list里面
    	request.setAttribute("userlist", list) ;
    	//跳转页面
    	 RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");    // 使用req对象获取RequestDispatcher对象
         dispatcher.forward(request, response);                                            // 使用RequestDispatcher对象在服务器端向目的路径跳转
    }
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		doGet(request,response) ;
    }
}
