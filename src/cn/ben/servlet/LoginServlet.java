package cn.ben.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // ���post����
		
		response.setHeader("Content-Type", "text/html;charset=UTF-8"); // �����������
		response.setHeader("Access-Control-Allow-Origin", "*");  // ��������


		// response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String formUserName = request.getParameter("userName");
		
		String formPassword = request.getParameter("password");
		
		
		System.out.print(formUserName + "and" + formPassword);
		
		out.print(formUserName + "and" + formPassword);
    

	}

}