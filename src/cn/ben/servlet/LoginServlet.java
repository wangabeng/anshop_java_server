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
	
	// �����˻�
    public static final String URL = "jdbc:mysql://116.62.240.193:3306/mshop";
    public static final String USER = "root";
    public static final String PASSWORD = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8"); // �����������
		response.setHeader("Access-Control-Allow-Origin", "*");  

		// response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	
        
        try {
        	//1.������������
			Class.forName("com.mysql.jdbc.Driver");
	        //2. ������ݿ�����
	        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        //3.�������ݿ⣬ʵ����ɾ�Ĳ�
	        String sql = "SELECT a.password FROM member a where a.mid=?";
	        
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        String username = "ben";
	        pstm.setString(1, username);
	        ResultSet rs = pstm.executeQuery();

	        //��������ݣ�rs.next()����true
	        while(rs.next()){
	        	// out.print(rs.getString("password"));
	        	String queryResult = rs.getString("password");
	        	if (queryResult.equals("4e4d6c332b6fe62a63afe56171fd3725")) {
	        		out.print(true);
	        	}
	        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.print("����");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("����");
			e.printStackTrace();
		}
		
		
	}

}