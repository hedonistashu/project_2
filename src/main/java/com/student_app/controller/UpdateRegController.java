package com.student_app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.student_app.model.DAO;
import com.student_app.model.DAOimpl;


public class UpdateRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateRegController() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		System.out.println(email);
		System.out.println(mobile);
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/UpdateReg.jsp");
		rd.forward(request, response);
		
		DAO dao = new DAOimpl();
		dao.connectDB();
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAO dao = new DAOimpl();
		dao.connectDB();
		
		dao.UpdateReg(email,mobile);
		
		ResultSet result = dao.getAllRegistrations();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showReg.jsp");
		rd.forward(request, response);
	}

}
