package com.RegistrationApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.RegistrationApp.model.DAOService;
import com.RegistrationApp.model.DAOServiceImpl;

@WebServlet("/saveReg")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewRegistrationController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
                            rd.forward(request, response);
          
          
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		DAOService service = new DAOServiceImpl();
		
		           service.connectDb();

	               service.saveRegistration(name, city, email, mobile);
	               
	               request.setAttribute("msg","Record is saved Succesfully!!");
	               
	               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		                              rd.forward(request, response);
		    
	}

}
