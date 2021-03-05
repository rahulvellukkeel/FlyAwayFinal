package com.user.flyaway;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.validator.PublicClassValidator;

import com.flyaway.admin.AdminInfo;
import com.flyaway.admin.Flightinfo;

public class Connect extends Flightinfo{
	public Connection getConnection() {
	Connection con=null;
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}
	public int passchange(AdminInfo a) {
		int status=0;
		Connection con=getConnection();
		String q="update flyaway.admin set password='"+a.getNewpassword()+"' where username='"+a.getUsername()+"'";
		try {
			Statement smt=con.createStatement();
			status=smt.executeUpdate(q);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public int login(AdminInfo a) {
		int status=0;
		Connection con=getConnection();
		try {
			Statement stmt=con.createStatement();
			String q="select * from flyaway.admin where username='"+a.getUsername()+"' and password='"+a.getPassword()+"'";
			status=stmt.executeUpdate(q);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			}
		return status;
	}
	public List<Flightinfo> flight() {
		List<Flightinfo> flist=new ArrayList<Flightinfo>();
		Connection con=getConnection();
		try {
			Statement stmt=con.createStatement();
			String q="select * from flyaway.flights";
			ResultSet rs=stmt.executeQuery(q);
			while(rs.next()) {
				Flightinfo fl=new Flightinfo();
				fl.setFid(rs.getString(1));
				fl.setSource(rs.getString(2));
				fl.setDestination(rs.getString(3));
				fl.setDate(rs.getDate(5));
				flist.add(fl);
			}
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return flist;
	}
	
	public List<Flightinfo> booking(Flightinfo fl){
		List<Flightinfo>flist=new ArrayList<Flightinfo>();
		Connection con=getConnection();
		//flist=null;
		try {
			Statement stmt=con.createStatement();
			String q="select * from flyaway.flights where source='"+fl.getSource()+"' and destination='"+fl.getDestination()+"'and DEPARTURE_DATE='"+fl.getDates()+"'";
			ResultSet rs=stmt.executeQuery(q);
			//if(rs.next()) {
			while(rs.next()) {
				
				Flightinfo flg=new Flightinfo();
				flg.setFid(rs.getString(1));
				flg.setSource(rs.getString(2));
				flg.setDestination(rs.getString(3));
				flg.setPrize(rs.getInt(4));
				flg.setDate(rs.getDate(5));
				flist.add(flg);
			}
			/*}else {
				//System.out.println("oombi");
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flist=null;
			e.printStackTrace();
		}
		return flist;	
	}
	public List<Flightinfo> flightByid(Flightinfo fl) {
		List<Flightinfo> flist=new ArrayList<Flightinfo>();
		Connection con=getConnection();
		try {
			Statement stmt=con.createStatement();
			String q="select * from flyaway.flights where fid='"+fl.getFid()+"'";
			ResultSet rs=stmt.executeQuery(q);
			while(rs.next()) {
				Flightinfo flg=new Flightinfo();
				flg.setFid(rs.getString(1));
				flg.setSource(rs.getString(2));
				flg.setDestination(rs.getString(3));
				flg.setPrize(rs.getInt(4));
				flg.setDate(rs.getDate(5));
				flist.add(flg);
			}
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return flist;
	}
	public java.util.Date StringToDate(String dob) throws ParseException {
	      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	      java.util.Date date = formatter.parse(dob);
	      return date;
	   }
	public List<Flightinfo> distinct() {
		List<Flightinfo> flist=new ArrayList<Flightinfo>();
		Connection con=getConnection();
		try {
			Statement stmt=con.createStatement();
			String q="select distinct source,destination from flyaway.flights";
			ResultSet rs=stmt.executeQuery(q);
			while(rs.next()) {
				Flightinfo fl=new Flightinfo();
				
				fl.setSource(rs.getString(1));
				fl.setDestination(rs.getString(2));
				flist.add(fl);
			}
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return flist;
	}
}
