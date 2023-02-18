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


public class newReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public newReg() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email")!=null) {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newReg.jsp");
		rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email")!=null) {
			
		
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAO dao = new DAOimpl();
		dao.connectDB();
		
		dao.NewRegistration(name,city,email,mobile);
		
		request.setAttribute("msg", "Record is saved");
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newReg.jsp");
		rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);

		}
		
	}

}
