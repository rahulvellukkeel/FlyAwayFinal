package com.flyaway.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.flyaway.Connect;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		AdminInfo a=new AdminInfo();
		Connect c=new Connect();
		HttpSession session=request.getSession();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		a.setUsername(uname);
		a.setPassword(pass);
		session.setAttribute("Admin", a);
		RequestDispatcher rd=null;
		int status=c.login(a);
		if(status>0){
			rd=request.getRequestDispatcher("Welcome");
			rd.forward(request, response);
		}else{
			out.print("<h3 align="+"center>"+"Invalid Login!!!</h3>");
			rd=request.getRequestDispatcher("welcome.html");
			rd.include(request, response);
		}
	}

}
