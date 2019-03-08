package cn.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 配置账户
    public static final String URL = "jdbc:mysql://116.62.240.193:3306/mshop";
    public static final String USER = "root";
    public static final String PASSWORD = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8"); // 解决中文乱码
		response.setHeader("Access-Control-Allow-Origin", "*");  

		// response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	
        
        try {
        	//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
	        //2. 获得数据库连接
	        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        //3.操作数据库，实现增删改查
	        String sql = "SELECT a.password FROM member a where a.mid=?";
	        
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        String username = "ben";
	        pstm.setString(1, username);
	        ResultSet rs = pstm.executeQuery();

	        //如果有数据，rs.next()返回true
	        while(rs.next()){
	        	// out.print(rs.getString("password"));
	        	String queryResult = rs.getString("password");
	        	if (queryResult.equals("4e4d6c332b6fe62a63afe56171fd3725")) {
	        		out.print(true);
	        	}
	        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.print("错误");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("错误");
			e.printStackTrace();
		}
		
		
	}

}