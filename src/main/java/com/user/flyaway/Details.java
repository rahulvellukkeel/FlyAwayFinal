package com.user.flyaway;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
 * Servlet implementation class Details
 */
@WebServlet("/details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/css");
		try {
		HttpSession session=request.getSession();
		PersonalInfo l=(PersonalInfo)session.getAttribute("ticket");
		List<PersonalInfo> pd=(List)session.getAttribute("details");
		int n=l.getNticket();
		int k=(int)session.getAttribute("loop");
		PersonalInfo p=new PersonalInfo();
		p.setPname(request.getParameter("pname"));
		p.setPlace(request.getParameter("place"));
		p.setAge(Integer.parseInt(request.getParameter("age")));
		pd.add(p);
		session.setAttribute("details",pd);
		if(k==1) {
			response.sendRedirect("payment.jsp");
		}else {
		k=k-1;
		session.setAttribute("loop", k);
		response.sendRedirect("BookingDetails.html");
		int prize = 0;
		String fname = null;
		String source = null;
		String Destination = null;
		Date Date = null;
		Flightinfo fll=new Flightinfo();
		List<Flightinfo> flist=(List)session.getAttribute("checkout");
		for(Flightinfo fl:flist) {
			prize=fl.getPrize();
			fname=fl.getFid();
			source=fl.getSource();
			Destination=fl.getDestination();
			Date=fl.getDate();
		}
		prize=n*prize;
		fll.setFid(fname);
		fll.setSource(source);
		fll.setDestination(Destination);
		fll.setDate(Date);
		fll.setPrize(prize);
		session.setAttribute("booked", fll);
		}
		}catch(Exception e) {
			response.sendRedirect("BookingDetails.html");
		}
	}

}
