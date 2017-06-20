package com.suncn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suncn.util.JdbcUtil;

public class UserAddServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Connection conn = JdbcUtil.getConnection() ;
    	JdbcUtil.beginTransaction(conn) ;
    	
    	//==============================================================================
    	String username = request.getParameter("username") ;
    	String password = request.getParameter("password") ;
    	String sql = " insert into tb_user (username,password) values('"+username+"','"+password+"')";
    	//执行sql语句
    	try {
			conn.createStatement().execute(sql) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	//==============================================================================
    	JdbcUtil.commitTransaction(conn) ;
    	//关闭数据库连接,让其他操作来进行连接 
    	//跳转页面
    	RequestDispatcher dispatcher = request.getRequestDispatcher("add_success.jsp");    // 使用req对象获取RequestDispatcher对象
        dispatcher.forward(request, response);                                            // 使用RequestDispatcher对象在服务器端向目的路径跳转
    }
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		doGet(request,response) ;
    }
}
