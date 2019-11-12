package com.training.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.SignUpDetailsDao;
import com.training.entity.SignUpDetails;
import com.training.utils.DbConnections;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection con = DbConnections.getOracleConnection();
		
		String strid = request.getParameter("userId");
	    int id = Integer.parseInt(strid);
	    String password = request.getParameter("passWord");
	    SignUpDetailsDao details = new SignUpDetailsDao(con);
	    SignUpDetails user=null;
	    try {
			user=details.findById(id,password);
			 if(user!=null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("TourPage.jsp");
					dispatcher.forward(request, response);
				    }
					else
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher("TravelAgencyHomePage.html");
						dispatcher.forward(request, response);
					}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		  Connection con = DbConnections.getOracleConnection();
		
		  String firstName = request.getParameter("firstName");
	      String lastName = request.getParameter("lastName");
	      String userType = request.getParameter("userType");
	      String strid = request.getParameter("id");
	      int id = Integer.parseInt(strid);
	      String password = request.getParameter("password");
		
		SignUpDetails info = new SignUpDetails(firstName,lastName,userType,id,password);
		SignUpDetailsDao details = new SignUpDetailsDao(con);
		System.out.println();
		try {
			details.add(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("TravelAgencyHomePage.html");
		dispatcher.forward(request, response);
		
	}

}

