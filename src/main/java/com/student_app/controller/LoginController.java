package com.student_app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.student_app.model.DAO;
import com.student_app.model.DAOimpl;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAO dao = new DAOimpl();
		dao.connectDB();
		
		boolean status = dao.verifyLoginCreditails(email, password);
		System.out.println(status);
		
		if (status==true) {
			HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newReg.jsp");
			rd.forward(request, response);
			
			
		} else {
			request.setAttribute("errorMsg", "Invalid username/password");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);

		}
	}

}
