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

import com.user.flyaway.Connect;

import oracle.net.ns.SessionAtts;

/**
 * Servlet implementation class passwrdchange
 */
@WebServlet("/passwrd")
public class passwrdchange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwrdchange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect c=new Connect();
		HttpSession session=request.getSession();
		AdminInfo a=new AdminInfo();
		a=(AdminInfo)session.getAttribute("Admin");
		int status=c.passchange(a);
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		if(status>0){
			rd=request.getRequestDispatcher("Welcome");
			out.print("Password Changed");
			rd.forward(request, response);
		}else{
			rd=request.getRequestDispatcher("Welcome");
			out.print("Error Occured");
			rd.include(request, response);
		}
	}

}
