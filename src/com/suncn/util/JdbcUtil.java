package com.suncn.util ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: JDBC连接类(示例连接mysql)
 * @CreateTime:2017-06-19 21:46:12
 * @author: huangdb 
 * @version V1.0
 */
public class JdbcUtil {
    //驱动名  
    private static String DRIVER = "com.mysql.jdbc.Driver";  
    //获得url  
    private static String URL = "jdbc:mysql://127.0.0.1:3306/jdbcdemo_20170619?characterEncoding=utf-8&useUnicode=true";  
    //获得连接数据库的用户名  
    private static String USERNAME = "root";  
    //获得连接数据库的密码  
    private static String PASSWORD = "123456";  

    static {  
        try {   
            //1.初始化JDBC驱动并让驱动加载到jvm中,加载JDBC驱动后,会将加载的驱动类注册给DriverManager类。
            Class.forName(DRIVER);  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
	
    public static Connection getConnection(){  
        Connection conn = null;  
        try {   
            //2.取得连接数据库  
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);  
            //3.开启自动提交
            conn.setAutoCommit(true);
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return conn;  
     }  

    //开启事务
    public static void beginTransaction(Connection conn) {  
        if (conn != null) {  
            try {  
                if (conn.getAutoCommit()) {  
                	conn.setAutoCommit(false);  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    //提交事务
    public static void commitTransaction(Connection conn) {  
        if (conn != null) {  
            try {  
                if (!conn.getAutoCommit()) {  
                	conn.commit();  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    //回滚事务
    public static void rollBackTransaction(Connection conn) {  
        if (conn != null) {  
            try {  
                if (!conn.getAutoCommit()) {  
                	conn.rollback();  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
	
     //关闭连接
     public static void close(Object o){  
        if (o == null){  
            return;  
        }  
        if (o instanceof ResultSet){  
            try {  
                ((ResultSet)o).close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        } else if(o instanceof Statement){  
            try {  
                ((Statement)o).close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        } else if (o instanceof Connection){  
            Connection c = (Connection)o;  
            try {  
                if (!c.isClosed()){  
                    c.close();  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }    
    }  

    //重载关闭连接
    public static void close(ResultSet rs, Statement stmt,   
            Connection conn){  
    	close(rs);  
    	close(stmt);  
    	close(conn);  
    }  
    //重载关闭连接
    public static void close(ResultSet rs,   
            Connection conn){  
    	close(rs);   
    	close(conn);  
    } 
    //重载关闭连接
    public static void close(ResultSet rs, PreparedStatement ps,   
            Connection conn){  
    	close(rs);  
    	close(ps);  
    	close(conn);  
    }  
}
