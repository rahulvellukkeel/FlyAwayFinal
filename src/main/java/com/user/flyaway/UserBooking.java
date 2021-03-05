package com.user.flyaway;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.admin.Flightinfo;

/**
 * Servlet implementation class UserBooking
 */
@WebServlet("/UserBooking")
public class UserBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBooking() {
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
		Connect c=new Connect();
		Flightinfo fl=new Flightinfo();
		HttpSession session=request.getSession();
		RequestDispatcher re=null;
		String did=request.getParameter("date");
		fl.setSource(request.getParameter("source"));
		fl.setDestination(request.getParameter("dest"));
		try {
			java.util.Date dates=c.StringToDate(did);
			String date= new SimpleDateFormat("dd-mm-yyyy").format(dates);
		if(date!=null) {
		fl.setDates(date);
		}
		List<Flightinfo>flist=c.booking(fl);
		if(flist!=null && !flist.isEmpty()) {
			session.setAttribute("pay", flist);
			re=request.getRequestDispatcher("flist.jsp");
			re.forward(request, response);	
		}
		else {
			out.print("No flights available");
			re=request.getRequestDispatcher("userwelcome.jsp");
			re.include(request, response);
			
		}
		}catch (Exception e) {
			e.printStackTrace();
			out.print("Fill the form correctly");
			re=request.getRequestDispatcher("userwelcome.jsp");
			re.include(request, response);
		}
		}
	}


