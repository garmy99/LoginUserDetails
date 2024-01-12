package com.RegistrationApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RegistrationApp.model.DAOService;
import com.RegistrationApp.model.DAOServiceImpl;


@WebServlet("/update")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                       
		                     String mobile = request.getParameter("mobile");
		                     String email = request.getParameter("email");
		                    
		                     request.setAttribute("mobile", mobile);
		                     request.setAttribute("email", email);
		                     
		                     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
		                     rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String mobile = request.getParameter("mobile");
          String email = request.getParameter("email");
          
          
          DAOService service = new DAOServiceImpl();
          
                       service.connectDb();
                       
                       service.updateRegistration(mobile,email);
                       
                       
                       ResultSet results = service.getAllRegistrations();

               		request.setAttribute("results", results);

               		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registrations.jsp");
               		rd.forward(request, response);

                       
		
		
	
	}

}
