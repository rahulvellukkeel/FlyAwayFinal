package com.flyaway.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WecomeServlet
 */
@WebServlet("/Welcome")
public class WecomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WecomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession sessio=request.getSession();
		AdminInfo a=new AdminInfo();
		a=(AdminInfo)sessio.getAttribute("Admin");
		out.print("<h1 align="+"center"+">Welcome " + a.getUsername()+ "</h1>");
		RequestDispatcher rd=request.getRequestDispatcher("AdminWelcome.html");
		rd.include(request, response);
	}

}
